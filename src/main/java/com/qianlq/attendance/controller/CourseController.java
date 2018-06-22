package com.qianlq.attendance.controller;

import com.qianlq.attendance.entity.CourseEntity;
import com.qianlq.attendance.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aqianliqing
 * @date 2018-03-22 下午3:37
 * mail: 1242202279@qq.com
 */

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public List<CourseEntity> findAllCourse() {
        return courseService.findAllCourse();
    }
}
