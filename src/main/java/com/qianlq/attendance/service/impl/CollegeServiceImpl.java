package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.entity.CollegeEntity;
import com.qianlq.attendance.repository.CollegeRepo;
import com.qianlq.attendance.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-22 下午2:47
 * mail: 1242202279@qq.com
 */

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepo collegeRepo;

    @Override
    public List<CollegeEntity> findAllCollege() {
        return collegeRepo.findAllCollege();
    }

    @Override
    public BaseResult findAll() {
        return BaseResultFactory.createSuccessResult(collegeRepo.findAll());
    }
}
