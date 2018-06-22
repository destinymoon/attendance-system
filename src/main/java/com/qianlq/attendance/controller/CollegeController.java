package com.qianlq.attendance.controller;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.service.CollegeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018-03-22 下午1:37
 * mail: 1242202279@qq.com
 */

@RestController
@RequestMapping(value = "/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @ApiOperation(value = "")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public BaseResult findAllCollege() {
        return collegeService.findAll();
    }
}
