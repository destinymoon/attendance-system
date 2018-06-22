package com.qianlq.attendance.controller;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.service.ClassroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018-03-24 上午11:12
 * mail: 1242202279@qq.com
 */

@RestController
@RequestMapping(value = "/classroom")
@Api(value = "教室管理", description = "教室模块", position = 1)
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @ApiOperation(value = "查询所有空教室", notes = "查询所有空教室接口")
    @RequestMapping(value = "/roo-available", method = RequestMethod.GET)
    public BaseResult getAvailableClassroom() {
        return classroomService.getAvailableRoo();
    }
}
