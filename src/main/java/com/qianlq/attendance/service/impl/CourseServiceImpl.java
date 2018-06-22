package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.entity.CourseEntity;
import com.qianlq.attendance.repository.CourseRepo;
import com.qianlq.attendance.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qianliqing
 * @Date: 2018-03-22 下午3:35
 * @Mail: 1242202279@qq.com
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<CourseEntity> findAllCourse() {
        return courseRepo.findAllCourse();
    }
}
