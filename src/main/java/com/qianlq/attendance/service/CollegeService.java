package com.qianlq.attendance.service;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.entity.CollegeEntity;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-22 下午1:38
 * mail: 1242202279@qq.com
 */

public interface CollegeService {

    List<CollegeEntity> findAllCollege();

    /**
     * 查询所有学院
     *
     * @return
     */
    BaseResult findAll();
}
