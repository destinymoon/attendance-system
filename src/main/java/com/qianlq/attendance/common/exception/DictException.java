package com.qianlq.attendance.common.exception;

/**
 * @author qianliqing
 * @date 2018-06-02 上午9:19
 * mail: 1242202279@qq.com
 */

public class DictException extends Exception {

    public DictException(String errorMsg) {
        super(errorMsg);
    }

    public DictException(String errorMsg, Throwable exception) {
        super(errorMsg, exception);
    }
}
