package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.common.ConstantFactory;
import com.qianlq.attendance.common.enums.Status;
import com.qianlq.attendance.common.enums.Type;
import com.qianlq.attendance.entity.AttendanceEntity;
import com.qianlq.attendance.entity.ResultEntity;
import com.qianlq.attendance.entity.TeacherEntity;
import com.qianlq.attendance.entity.TimetableEntity;
import com.qianlq.attendance.model.vo.*;
import com.qianlq.attendance.repository.*;
import com.qianlq.attendance.service.TeacherService;
import com.qianlq.attendance.util.MD5Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @author qianliqing
 * @date 2018-03-23 下午3:35
 * mail: 1242202279@qq.com
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private TimetableRepo timetableRepo;
    @Autowired
    private AttendanceRepo attendanceRepo;
    @Autowired
    private ResultRepo resultRepo;

    /**
     * 判断签到是否在进行中
     *
     * @param attendance AttendanceVo对象
     * @return String
     */
    private String setStatus(AttendanceVo attendance) {
        Date current = new Timestamp(System.currentTimeMillis());

        String status = attendance.getStatus();
        Date timeout = attendance.getTimeout();
        if (status.equals(ConstantFactory.getStatus(Status.ATTENDANCE_CANCEL))) {
            return ConstantFactory.getDesc(Status.ATTENDANCE_CANCEL);
        } else if (current.after(timeout) && status.equals(ConstantFactory.getStatus(Status.ATTENDANCE_UNDERWAY))) {
            AttendanceEntity entity = attendanceRepo.findAllByAttNo(attendance.getAttNo());
            entity.setStatus(ConstantFactory.getStatus(Status.ATTENDANCE_FINISH));
            attendanceRepo.save(entity);

            return ConstantFactory.getDesc(Status.ATTENDANCE_FINISH);
        } else if (current.before(timeout) && status.equals(ConstantFactory.getStatus(Status.ATTENDANCE_UNDERWAY))) {
            return ConstantFactory.getDesc(Status.ATTENDANCE_UNDERWAY);
        } else {
            return ConstantFactory.getDesc(status, Type.ATTENDANCE);
        }
    }

    /**
     * 根据账号查询详细信息
     *
     * @param account 教工号
     * @return BaseResult
     */
    @Override
    public BaseResult getTeaDetailInfo(String account) {
        TeacherVo vo = teacherRepo.findDetailByTeaNo(account);
        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 根据密码账号登录
     *
     * @param account  教工号
     * @param password 密码
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    public BaseResult doLogin(String account, String password) {
        TeacherEntity teacher = teacherRepo.findByTeaNoAndPassword(account, MD5Utils.string2MD5(password));
        UserVo vo = null;
        if (teacher != null) {
            TeacherVo stu = teacherRepo.findDetailByTeaNo(teacher.getTeaNo());
            vo = new UserVo(stu);
        }

        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 更新个人基本信息
     *
     * @param account  教工号
     * @param password 密码
     * @param name     姓名
     * @param phone    手机号码
     * @param email    电子邮箱
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public BaseResult updateTeaBaseInfo(String account, String password, String name, String phone, String email) {

        TeacherEntity teacher = this.teacherRepo.findByTeaNo(account);

        teacher.setPassword(MD5Utils.string2MD5(password));
        teacher.setTeaName(name);
        teacher.setPhone(phone);
        teacher.setEmail(email);

        this.teacherRepo.save(teacher);

        return BaseResultFactory.createSuccessResult();
    }

    /**
     * 查询教师课表
     *
     * @param account 教工号
     * @return BaseResult
     */
    @Override
    public BaseResult getTeaSchedule(String account) {
        List<ScheduleVo> vos = scheduleRepo.findByTabTeaNo(account);
        return BaseResultFactory.createSuccessResult(vos);
    }

    /**
     * 查询课程上课学生
     *
     * @param tabNo 课程表编号
     * @return BaseResult
     */
    @Override
    public BaseResult getCouStudent(String tabNo) {
        List<StudentVo> vos = scheduleRepo.findByTabNo(tabNo);
        return BaseResultFactory.createSuccessResult(vos);
    }

    /**
     * 发布签到
     *
     * @param account   教师编号
     * @param tabNo     课程表编号
     * @param place     签到地点
     * @param longitude 定位经度
     * @param latitude  定位维度
     * @param timeout   超时时间
     * @param remark    备注
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public BaseResult issueSignIn(String account, String tabNo, String place, String longitude, String latitude, String time, String timeout, String remark) {
        String status = ConstantFactory.getStatus(Status.RESULT_FALSE);

        Date createdAt;
        // question: 前端传值var time = null; 后台收到的值为 null 字符串
        if (time != null && !"null".equals(time) && format.parse(time).after(new Date())) {
            createdAt = format.parse(time);
        } else {
            createdAt = new Timestamp(System.currentTimeMillis());
        }

        TimetableEntity timetable = timetableRepo.findByTabNo(tabNo);
        AttendanceEntity attendance;
        if (timetable != null) {
            Date date = new Timestamp(createdAt.getTime() + Long.parseLong(timeout) * 60 * 1000L);
            attendance = new AttendanceEntity(account, tabNo, place, longitude, latitude, createdAt, date, remark, ConstantFactory.getStatus(Status.ATTENDANCE_UNDERWAY));
            attendanceRepo.save(attendance);
        } else {
            return BaseResultFactory.createFailedResult();
        }
        List<StudentVo> vos = scheduleRepo.findByTabNo(tabNo);
        vos.forEach(e -> {
            String attNo = attendance.getAttNo();
            String stuNo = e.getAccount();
            ResultEntity result = new ResultEntity(attNo, tabNo, stuNo, status, createdAt);
            resultRepo.save(result);
        });

        return BaseResultFactory.createSuccessResult();
    }

    /**
     * 查询历史记录
     *
     * @param account 教师编号
     * @param time    时间
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public BaseResult getHistory(String account, String time) {
        String status = ConstantFactory.getStatus(Status.RESULT_TRUE);
        List<AttendanceVo> attendance = attendanceRepo.findByAttTeaNoOrderByCreatedAtDesc(account, format.parse(time));

        Collections.sort(attendance);

        List<TeaHistoryVo> vos = new ArrayList<>();
        if (attendance.size() > 0) {
            attendance.forEach(e -> {
                String tabNo = e.getTabNo();
                TimetableVo timetable = timetableRepo.findDetailByTabNo(tabNo);
                String attNo = e.getAttNo();
                int totalNum = resultRepo.countByResAttNo(attNo);
                int signNum = resultRepo.countByResAttNoAndStatus(attNo, status);
                TeaHistoryVo vo = new TeaHistoryVo(timetable, e, totalNum, signNum, setStatus(e));
                vos.add(vo);
            });
        }
        HistoryVo vo = new HistoryVo(vos, null);

        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 查询学生签到情况
     *
     * @param attNo 签到编号
     * @return BaseResult
     */
    @Override
    public BaseResult getResult(String attNo) {
        List<ResultEntity> result = resultRepo.findByResAttNo(attNo);

        List<ResultVo> vos = new ArrayList<>();
        if (result != null && result.size() > 0) {
            result.forEach(e -> {
                String stuNo = e.getResStuNo();
                StudentVo student = studentRepo.findDetailByStuNo(stuNo);
                UserVo user = new UserVo(student);
                user.setPhone(student.getPhone());
                ResultVo vo = new ResultVo(user, e);
                vos.add(vo);
            });
        }

        SignResultVo vo = new SignResultVo(vos);

        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 取消最近时间的签到
     *
     * @param attNo 签到编号
     * @return BaseResult
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResult cancelSignIn(String attNo) {
        AttendanceEntity attendance = attendanceRepo.findAllByAttNo(attNo);
        attendance.setStatus(ConstantFactory.getStatus(Status.ATTENDANCE_CANCEL));
        attendanceRepo.save(attendance);
        return BaseResultFactory.createSuccessResult();
    }

    /**
     * 查询课程学期汇总情况
     *
     * @param focus 课程表编号
     * @return BaseResult
     */
    @Override
    public BaseResult getSummary(String focus) {
        String status = ConstantFactory.getStatus(Status.ATTENDANCE_CANCEL);
        List<TimetableVo> timetable = timetableRepo.findByFocus(focus);

        List<SummaryVo> vos = new ArrayList<>();
        if (timetable != null && timetable.size() > 0) {

            timetable.forEach(t -> {
                String tabNo = t.getTabNo();
                List<StudentVo> student = scheduleRepo.findByTabNo(tabNo);

                List<StuSummaryVo> summary = new ArrayList<>();
                student.forEach(e -> {
                    UserVo user = new UserVo(e);
                    int signNum = resultRepo.countByResStuNoAndResTabNoAndStatus(e.getAccount(), tabNo, ConstantFactory.getStatus(Status.RESULT_TRUE), status);
                    int leaveNum = resultRepo.countByResStuNoAndResTabNoAndStatus(e.getAccount(), tabNo, ConstantFactory.getStatus(Status.RESULT_LEAVE), status);
                    StuSummaryVo vo = new StuSummaryVo(user, signNum, leaveNum);
                    summary.add(vo);
                });

                int totalNum = attendanceRepo.countByAttTabNoAndStatusNot(tabNo, status);
                SummaryVo vo = new SummaryVo(totalNum, t, summary);
                vos.add(vo);
            });

        }

        return BaseResultFactory.createSuccessResult(vos);
    }
}
