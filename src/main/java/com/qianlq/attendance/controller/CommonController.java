package com.qianlq.attendance.controller;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.service.CommonService;
import com.qianlq.attendance.service.StudentService;
import com.qianlq.attendance.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qianliqing
 * @date 2018-04-21 下午3:33
 * mail: 1242202279@qq.com
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/common")
@Api(value = "通用管理", description = "通用模块", position = 1)
public class CommonController {

    private static final String LOGIN_TYPE = "0";

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public BaseResult login(@RequestParam(value = "account") String account,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "type") String type) {
        return LOGIN_TYPE.equals(type) ? studentService.doLogin(account, password) : teacherService.doLogin(account, password);
    }

    @ApiOperation(value = "查询教师信息", notes = "查询教师信息接口")
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public BaseResult getTeaInfo(@RequestParam(value = "name") String name) {
        return commonService.getTeaInfo(name);
    }

    @ApiOperation(value = "公告", notes = "公告接口")
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public BaseResult notice() {
        return commonService.getNotice();
    }
}
