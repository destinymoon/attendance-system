package com.qianlq.attendance.service;

import com.qianlq.attendance.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-04-21 下午4:11
 * mail: 1242202279@qq.com
 */

public interface CommonService {

    /**
     * 根据教师姓名模糊查询
     *
     * @param teaName 教师姓名
     * @return BaseResult
     */
    BaseResult getTeaInfo(String teaName);

    /**
     * 查看公告
     *
     * @return BaseResult
     */
    BaseResult getNotice();
}
