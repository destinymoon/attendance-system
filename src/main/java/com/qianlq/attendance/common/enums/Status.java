package com.qianlq.attendance.common.enums;

/**
 * @author qianliqing
 * @date 2018-04-13 下午7:49
 * mail: 1242202279@qq.com
 *
 * 签到状态表
 */

public enum Status {

    RESULT_FALSE("0", "未签到", Type.RESULT),
    RESULT_TRUE("1", "已签到", Type.RESULT),
    RESULT_LEAVE("2", "请假", Type.RESULT),

    CLASSROOM_AVAILABLE("0", "空教室", Type.CLASSROOM),
    CLASSROOM_OCCUPIED("1", "已被占用", Type.CLASSROOM),

    ATTENDANCE_UNDERWAY("0", "签到中", Type.ATTENDANCE),
    ATTENDANCE_FINISH("1", "签到结束", Type.ATTENDANCE),
    ATTENDANCE_CANCEL("2", "签到取消", Type.ATTENDANCE);

    private String status;
    private String desc;
    private Type type;

    Status(String status, String desc, Type type) {
        this.status = status;
        this.desc = desc;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static String getDesc(String value, Type type) {
        for (Status status : Status.values()) {
            if (value.equals(status.getStatus()) && type.equals(status.getType())) {
                return status.getDesc();
            }
        }
        return null;
    }
}
