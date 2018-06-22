package com.qianlq.attendance.common.enums;

/**
 * @author qianliqing
 * @date 2018-04-15 下午12:35
 * mail: 1242202279@qq.com
 */

public enum Type {
    RESULT("result"), CLASSROOM("classroom"), ATTENDANCE("attendance");

    private String desc;

    Type(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
