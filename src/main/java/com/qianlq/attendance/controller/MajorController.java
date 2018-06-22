package com.qianlq.attendance.controller;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.service.MajorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:26
 * mail: 1242202279@qq.com
 */

@RestController
@RequestMapping(value = "/major")
@Api(value = "专业管理", description = "专业模块", position = 1)
public class MajorController {

    @Autowired
    private MajorService majorService;

    @ApiOperation(value = "查询学院所有专业", notes = "查询学院所有专业接口")
    @RequestMapping(value = "/col-all-major", method = RequestMethod.GET)
    public BaseResult findColMajor(@RequestParam(value = "colNo", required = false) String colNo) {
        return majorService.getCollegeMajor(colNo);
    }
}
