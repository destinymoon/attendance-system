package com.qianlq.attendance.service;

import com.qianlq.attendance.entity.CourseEntity;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:35
 * mail: 1242202279@qq.com
 */

public interface CourseService {
    List<CourseEntity> findAllCourse();
}
