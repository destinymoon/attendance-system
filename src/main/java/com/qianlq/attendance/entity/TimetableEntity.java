package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-03-24 下午12:14
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "timetable")
public class TimetableEntity extends BaseEntity {

    /**
     * 课表编号
     */
    @Id
    @Column(name = "tab_no", columnDefinition = "varchar(40) NOT NULL COMMENT '课表编号'")
    private String tabNo;

    /**
     * 一周多节课的情况
     */
    @Column(name = "focus", columnDefinition = "varchar(8) NOT NULL COMMENT '一周多节课的情况'")
    private String focus;

    /**
     * 授课课程
     */
    @Column(name = "tab_cou_no", columnDefinition = "varchar(8) NOT NULL COMMENT '课表编号'")
    private String tabCouNo;

    /**
     * 授课老师
     */
    @Column(name = "tab_tea_no", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '外键，授课老师'")
    private String tabTeaNo;

    /**
     * 上课教室
     */
    @Column(name = "tab_roo_no", columnDefinition = "varchar(8) NOT NULL COMMENT '外键，上课教室'")
    private String tabRooNo;

    /**
     * 上课时间
     */
    @Column(name = "tab_tim_no", columnDefinition = "varchar(8) NOT NULL COMMENT '外键，上课时间'")
    private String tabTimNo;

    /**
     * 创建时间
     */
    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp comment '创建时间'")
    private Date createdAt;

    /**
     * 更新时间
     */
    @Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp comment '最近一次更新时间'")
    private Date updatedAt;
}
