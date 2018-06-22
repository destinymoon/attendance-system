package com.qianlq.attendance.service;

import com.qianlq.attendance.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-03-24 上午11:07
 * mail: 1242202279@qq.com
 */

public interface ClassroomService {

    /**
     * 查询所有空教室
     *
     * @return BaseResult
     */
    BaseResult getAvailableRoo();
}
