package com.qianlq.attendance.controller;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qianliqing
 * @date 2018-03-24 上午9:54
 * mail: 1242202279@qq.com
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/teacher")
@Api(value = "教师管理", description = "教师模块", position = 1)
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "老师查询个人基本信息", notes = "老师查询个人基本信息接口")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public BaseResult getDetailInfo(@RequestParam(value = "account") String account) {
        return teacherService.getTeaDetailInfo(account);
    }

    @ApiOperation(value = "老师更新个人基本信息", notes = "老师更新个人基本信息接口")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult updateBaseInfo(@RequestParam(value = "account") String account,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "phone", required = false) String phone,
                                     @RequestParam(value = "email", required = false) String email) {
        return teacherService.updateTeaBaseInfo(account, password, name, phone, email);
    }

    @ApiOperation(value = "老师查询课表信息", notes = "老师更新课表信息接口")
    @RequestMapping(value = "/timetable", method = RequestMethod.GET)
    public BaseResult getSchedule(@RequestParam(value = "account") String account) {
        return teacherService.getTeaSchedule(account);
    }

    @ApiOperation(value = "老师查询课程学生信息", notes = "老师查询课程学生信息接口")
    @RequestMapping(value = "/timetable/stu-list", method = RequestMethod.GET)
    public BaseResult getStudentList(@RequestParam(value = "timetableNo") String timetableNo) {
        return teacherService.getCouStudent(timetableNo);
    }

    @ApiOperation(value = "老师发布签到", notes = "老师发布签到接口")
    @RequestMapping(value = "/attendance/issue", method = RequestMethod.POST)
    public BaseResult issueSignIn(@RequestParam(value = "account") String account,
                                  @RequestParam(value = "timetableNo") String timetableNo,
                                  @RequestParam(value = "place") String place,
                                  @RequestParam(value = "longitude") String longitude,
                                  @RequestParam(value = "latitude") String latitude,
                                  @RequestParam(value = "time", required = false) String time,
                                  @RequestParam(value = "timeout") String timeout,
                                  @RequestParam(value = "remark", required = false) String remark) {
        return teacherService.issueSignIn(account, timetableNo, place, longitude, latitude, time, timeout, remark);
    }

    @ApiOperation(value = "老师查询历史签到情况", notes = "老师查询历史签到情况接口")
    @RequestMapping(value = "/attendance/history", method = RequestMethod.GET)
    public BaseResult getHistory(@RequestParam(value = "account") String account,
                                 @RequestParam(value = "time") String time) {
        return teacherService.getHistory(account, time);
    }

    @ApiOperation(value = "老师查询签到情况", notes = "老师查询签到情况接口")
    @RequestMapping(value = "/attendance/result", method = RequestMethod.GET)
    public BaseResult getResult(@RequestParam(value = "attendanceNo") String attendanceNo) {
        return teacherService.getResult(attendanceNo);
    }

    @ApiOperation(value = "老师取消签到", notes = "老师取消签到接口")
    @RequestMapping(value = "/attendance/cancel", method = RequestMethod.POST)
    public BaseResult cancelSignIn(@RequestParam(value = "attendanceNo") String attendanceNo) {
        return teacherService.cancelSignIn(attendanceNo);
    }

    @ApiOperation(value = "老师查询课程学期汇总", notes = "老师查询课程学期汇总接口")
    @RequestMapping(value = "/attendance/summary", method = RequestMethod.GET)
    public BaseResult getSummary(@RequestParam(value = "focus") String focus) {
        return teacherService.getSummary(focus);
    }
}
