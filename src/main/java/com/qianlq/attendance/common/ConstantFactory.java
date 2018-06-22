package com.qianlq.attendance.common;

import com.qianlq.attendance.common.enums.Status;
import com.qianlq.attendance.common.enums.Type;
import com.qianlq.attendance.common.exception.DictException;

/**
 * @author qianliqing
 * @date 2018-04-13 下午8:01
 * mail: 1242202279@qq.com
 */

public class ConstantFactory {

    /**
     * 直接获取字典值
     *
     * @param status 枚举
     * @return String
     */
    public static String getStatus(Status status) {
        return status.getStatus();
    }

    /**
     * 直接获取字典值描述
     *
     * @param status 枚举
     * @return String
     */
    public static String getDesc(Status status) {
        return status.getDesc();
    }


    /**
     * 根据字典值获取字典值描述
     *
     * @param status 枚举
     * @return String
     */
    public static String getDesc(String status, Type type) {
        return Status.getDesc(status, type);
    }
}
