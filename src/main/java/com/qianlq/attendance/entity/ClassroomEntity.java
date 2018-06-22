package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

/**
 * @author qianliqing
 * @date 2018-03-24 上午11:00
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classroom")
public class ClassroomEntity extends BaseEntity {

    /**
     * 教室编号
     */
    @Id
    @Column(name = "roo_no", columnDefinition = "varchar(8) unsigned NOT NULL COMMENT '教室编号'")
    private String rooNo;

    /**
     * 教室
     */
    @Column(name = "roo_name", columnDefinition = "varchar(64) DEFAULT NULL COMMENT '具体教室'")
    private String rooName;

    /**
     * 教室情况
     */
    @Column(name = "status", columnDefinition = "varchar(2) DEFAULT NULL COMMENT '教室情况'")
    private String status;
}
