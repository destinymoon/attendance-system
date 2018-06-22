package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.common.ConstantFactory;
import com.qianlq.attendance.common.constant.Result;
import com.qianlq.attendance.common.enums.Status;
import com.qianlq.attendance.common.enums.Type;
import com.qianlq.attendance.entity.ResultEntity;
import com.qianlq.attendance.entity.StudentEntity;
import com.qianlq.attendance.model.vo.*;
import com.qianlq.attendance.repository.*;
import com.qianlq.attendance.service.StudentService;
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
 * @date 2018-03-19 下午2:54
 * mail: 1242202279@qq.com
 */

@Service
public class StudentServiceImpl implements StudentService {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private ResultRepo resultRepo;
    @Autowired
    private AttendanceRepo attendanceRepo;
    @Autowired
    private TimetableRepo timetableRepo;

    /**
     * 根据账号查询详细信息
     *
     * @param account 学号
     * @return BaseResult
     */
    @Override
    public BaseResult getStuDetailInfo(String account) {
        StudentVo vo = studentRepo.findDetailByStuNo(account);
        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 根据账号密码登录
     *
     * @param account  学号
     * @param password 密码
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    public BaseResult doLogin(String account, String password) {
        StudentEntity student = studentRepo.findByStuNoAndPassword(account, MD5Utils.string2MD5(password));
        UserVo vo = null;
        if (student != null) {
            StudentVo stu = studentRepo.findDetailByStuNo(student.getStuNo());
            vo = new UserVo(stu);
        }

        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 更新学生基本信息
     *
     * @param account  学号
     * @param password 密码
     * @param name     姓名
     * @param phone    手机号码
     * @param email    电子邮箱
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public BaseResult updateStuBaseInfo(String account, String password, String name, String phone, String email) {
        StudentEntity student = this.studentRepo.findByStuNo(account);

        student.setPassword(MD5Utils.string2MD5(password));
        student.setStuName(name);
        student.setPhone(phone);
        student.setEmail(email);

        studentRepo.save(student);

        return BaseResultFactory.createSuccessResult();
    }

    /**
     * 查询学生课表
     *
     * @param account 学号
     * @return BaseResult
     */
    @Override
    public BaseResult getStuSchedule(String account) {
        List<ScheduleVo> vos = scheduleRepo.findByTabStuNo(account);
        return BaseResultFactory.createSuccessResult(vos);
    }

    /**
     * 查询最近时间的签到记录
     *
     * @param account 学号
     * @return BaseResult
     */
    @Override
    public BaseResult getLastRecord(String account) {
        Date date = new Timestamp(System.currentTimeMillis());
        ResultEntity result = resultRepo.findByStuNoAndStatusAndTime(account, date, ConstantFactory.getStatus(Status.RESULT_FALSE), ConstantFactory.getStatus(Status.ATTENDANCE_UNDERWAY));
        RecordVo vo = null;
        if (result != null) {
            String attNo = result.getResAttNo();
            AttendanceVo attendance = attendanceRepo.findByAttNo(attNo);
            String tabNo = attendance.getTabNo();
            TimetableVo timetable = timetableRepo.findDetailByTabNo(tabNo);
            vo = new RecordVo(timetable, attendance, ConstantFactory.getDesc(result.getStatus(), Type.RESULT));
        }
        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 签到
     *
     * @param account 学号
     * @param place   签到定位
     * @return BaseResult
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public BaseResult doSignIn(String account, String attNo, String place) {
        BaseResult result;

        String status = ConstantFactory.getStatus(Status.RESULT_TRUE);
        ResultEntity entity = resultRepo.findByResStuNoAndResAttNo(account, attNo);
        if (entity != null) {
            AttendanceVo attendance = attendanceRepo.findByAttNo(attNo);
            if (attendance.getTimeout().after(new Date())) {
                entity.setStatus(status);
                entity.setPlace(place);
                entity.setUpdatedAt(new Date());
                resultRepo.save(entity);

                result = new BaseResult(Result.SUCCESS, "签到成功");
            } else {
                result = new BaseResult(Result.FAILED, "签到已经超时");
            }
        } else {
            result = new BaseResult(Result.UNKNOW, "未知异常");
        }

        return result;
    }

    /**
     * 查询历史签到情况
     *
     * @param account 学号
     * @param time    时间
     * @return BaseResult
     */
    @Override
    @SneakyThrows
    public BaseResult getHistory(String account, String time) {
        Date date = new Timestamp(System.currentTimeMillis());
        List<ResultEntity> result = resultRepo.findByResStuNoOrderByCreatedAtDesc(account, ConstantFactory.getStatus(Status.ATTENDANCE_CANCEL), format.parse(time), date);

        Collections.sort(result);

        List<StuHistoryVo> vos = new ArrayList<>();
        if (result.size() > 0) {
            result.forEach(e -> {
                String status = ConstantFactory.getDesc(e.getStatus(), Type.RESULT);
                String attNo = e.getResAttNo();
                AttendanceVo attendance = attendanceRepo.findByAttNo(attNo);
                String tabNo = attendance.getTabNo();
                TimetableVo timetable = timetableRepo.findDetailByTabNo(tabNo);
                StuHistoryVo vo = new StuHistoryVo(timetable, attendance, status);
                vos.add(vo);
            });
        }
        HistoryVo vo = new HistoryVo(null, vos);

        return BaseResultFactory.createSuccessResult(vo);
    }


    /**
     * 请假
     *
     * @param account 学号
     * @param attNo   签到编号
     * @param remark  备注
     * @return BaseResult
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    public BaseResult applyLeave(String account, String attNo, String remark) {
        BaseResult result;

        String status = ConstantFactory.getStatus(Status.RESULT_LEAVE);
        ResultEntity entity = resultRepo.findByResStuNoAndResAttNo(account, attNo);
        if (entity != null) {
            AttendanceVo attendance = attendanceRepo.findByAttNo(attNo);
            if (attendance.getTimeout().after(new Date())) {
                entity.setStatus(status);
                entity.setRemark(remark);
                entity.setUpdatedAt(new Date());
                resultRepo.save(entity);

                result = new BaseResult(Result.SUCCESS, "请假成功");
            } else {
                result = new BaseResult(Result.FAILED, "签到已经超时");
            }
        } else {
            result = new BaseResult(Result.UNKNOW, "未知异常");
        }

        return result;
    }
}
