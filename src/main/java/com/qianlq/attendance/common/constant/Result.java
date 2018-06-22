package com.qianlq.attendance.common.constant;

/**
 * @author qianliqing
 * @date 2018-03-20 下午3:56
 * mail: 1242202279@qq.com
 */

public enum Result {
    FAILED(-1, "失败"), UNKNOW(0, "未知错误"), SUCCESS(1, "成功");

    private int code;
    private String msg;

    Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
