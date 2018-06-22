package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.repository.MajorRepo;
import com.qianlq.attendance.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:25
 * mail: 1242202279@qq.com
 */

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepo majorRepo;

    @Override
    public BaseResult getCollegeMajor(String colNo) {
        return BaseResultFactory.createSuccessResult(majorRepo.findByMajColNo(colNo));
    }
}
