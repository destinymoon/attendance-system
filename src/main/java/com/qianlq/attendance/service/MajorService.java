package com.qianlq.attendance.service;

import com.qianlq.attendance.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:24
 * mail: 1242202279@qq.com
 */

public interface MajorService {

    /**
     * 查询专业
     *
     * @param colNo 学院编号
     * @return BaseResult
     */
    BaseResult getCollegeMajor(String colNo);
}
