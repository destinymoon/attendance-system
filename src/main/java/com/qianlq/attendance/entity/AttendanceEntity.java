package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-04-10 下午3:36
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attendance")
@EntityListeners(AuditingEntityListener.class)
public class AttendanceEntity extends BaseEntity {

    /**
     * 主键uuid
     */
    @Id
    @GenericGenerator(name = "id_uuid", strategy = "uuid")
    @GeneratedValue(generator = "id_uuid")
    @Column(name = "att_no", columnDefinition = "varchar(40) NOT NULL COMMENT 'uuid'")
    private String attNo;

    /**
     * 具体课程
     */
    @Column(name = "att_tab_no", columnDefinition = "varchar(40) DEFAULT NULL COMMENT '外键，对应课程信息'")
    private String attTabNo;

    /**
     * 发布签到的老师
     */
    @Column(name = "att_tea_no", columnDefinition = "varchar(8) DEFAULT NULL COMMENT '外键，对应老师'")
    private String attTeaNo;

    /**
     * 签到地点
     */
    @Column(name = "place", columnDefinition = "varchar(256) DEFAULT NULL COMMENT '定位地点'")
    private String place;

    /**
     * 定位经度
     */
    @Column(name = "longitude", columnDefinition = "varchar(24) DEFAULT NULL COMMENT '定位经度'")
    private String longitude;

    /**
     * 定位维度
     */
    @Column(name = "latitude", columnDefinition = "varchar(24) DEFAULT NULL COMMENT '定位维度'")
    private String latitude;

    /**
     * 签到超时时间
     */
    @Column(name = "timeout", columnDefinition = "timestamp DEFAULT NULL COMMENT '超时时间'")
    private Date timeout;

    /**
     * 签到备注
     */
    @Column(name = "remark", columnDefinition = "varchar(256) DEFAULT NULL COMMENT '备注信息'")
    private String remark;

    /**
     * 状态，0签到中/1签到结束/2签到取消
     */
    @Column(name = "status", columnDefinition = "varchar(2) DEFAULT DEFAULT '0' COMMENT '状态，0签到中/1签到结束/2签到取消'")
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "created_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createdAt;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次更新时间'")
    private Date updatedAt;

    public AttendanceEntity(String teaNo, String tabNo, String place, String longitude, String latitude, Date timeout, String remark, String status) {
        this.attTeaNo = teaNo;
        this.attTabNo = tabNo;
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timeout = timeout;
        this.remark = remark;
        this.status = status;
    }

    public AttendanceEntity(String teaNo, String tabNo, String place, String longitude, String latitude, Date time, Date timeout, String remark, String status) {
        this.attTeaNo = teaNo;
        this.attTabNo = tabNo;
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createdAt = time;
        this.timeout = timeout;
        this.remark = remark;
        this.status = status;
    }
}
