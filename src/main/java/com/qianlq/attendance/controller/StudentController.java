package com.qianlq.attendance.controller;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qianliqing
 * @date 2018-03-19 下午3:29
 * mail: 1242202279@qq.com
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/student")
@Api(value = "学生管理", description = "学生模块", position = 1)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "学生查询个人基本信息", notes = "学生查询个人基本信息接口")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public BaseResult getDetailInfo(@RequestParam(value = "account") String account) {
        return studentService.getStuDetailInfo(account);
    }

    @ApiOperation(value = "学生更新个人基本信息", notes = "学生更新个人基本信息接口")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult updateBaseInfo(@RequestParam(value = "account") String account,
                                     @RequestParam(value = "password", required = false) String password,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "phone", required = false) String phone,
                                     @RequestParam(value = "email", required = false) String email) {
        return studentService.updateStuBaseInfo(account, password, name, phone, email);
    }

    @ApiOperation(value = "学生查询课表信息", notes = "学生查询课表信息接口")
    @RequestMapping(value = "/timetable", method = RequestMethod.GET)
    public BaseResult getSchedule(@RequestParam(value = "account") String account) {
        return studentService.getStuSchedule(account);
    }

    @ApiOperation(value = "学生查询最近时间的签到记录", notes = "学生查询最近时间的签到记录接口")
    @RequestMapping(value = "/attendance/last-record", method = RequestMethod.GET)
    public BaseResult getLastRecord(@RequestParam(value = "account") String account) {
        return studentService.getLastRecord(account);
    }

    @ApiOperation(value = "学生进行签到", notes = "学生签到接口")
    @RequestMapping(value = "/attendance/sign", method = RequestMethod.POST)
    public BaseResult doSignIn(@RequestParam(value = "account") String account,
                               @RequestParam(value = "attendanceNo") String attendanceNo,
                               @RequestParam(value = "place") String place) {
        return studentService.doSignIn(account, attendanceNo, place);
    }

    @ApiOperation(value = "学生请假", notes = "学生请假接口")
    @RequestMapping(value = "/attendance/leave", method = RequestMethod.POST)
    public BaseResult applyLeave(@RequestParam(value = "account") String account,
                               @RequestParam(value = "attendanceNo") String attendanceNo,
                               @RequestParam(value = "remark") String remark) {
        return studentService.applyLeave(account, attendanceNo, remark);
    }

    @ApiOperation(value = "学生查询历史签到情况", notes = "学生查询历史签到情况接口")
    @RequestMapping(value = "/result/history", method = RequestMethod.GET)
    public BaseResult getHistory(@RequestParam(value = "account") String account,
                                 @RequestParam(value = "time", required = false) String time) {
        return studentService.getHistory(account, time);
    }
}
