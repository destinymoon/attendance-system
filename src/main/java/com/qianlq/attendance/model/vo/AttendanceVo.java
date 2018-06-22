package com.qianlq.attendance.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-04-13 下午5:59
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceVo implements Comparable<AttendanceVo> {

    private String attNo;

    private String tabNo;

    private Date createdAt;

    private Date timeout;

    private String place;

    private String longitude;

    private String latitude;

    private String remark;

    private String status;

    public AttendanceVo(String attNo, String tabNo, Date createdAt, Date timeout, String place, String remark, String status) {
        this.attNo = attNo;
        this.tabNo = tabNo;
        this.createdAt = createdAt;
        this.timeout = timeout;
        this.place = place;
        this.remark = remark;
        this.status = status;
    }

    public AttendanceVo(String attNo, String tabNo, Date createdAt, Date timeout, String place, String longitude, String latitude, String remark) {
        this.attNo = attNo;
        this.tabNo = tabNo;
        this.createdAt = createdAt;
        this.timeout = timeout;
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
        this.remark = remark;
    }

    @Override
    public int compareTo(AttendanceVo o) {
        return -createdAt.compareTo(o.createdAt);
    }
}
