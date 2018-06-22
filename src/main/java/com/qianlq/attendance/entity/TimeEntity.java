package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

/**
 * @author qianliqing
 * @date 2018-03-24 下午9:22
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "time")
public class TimeEntity extends BaseEntity {

    /**
     * 时间编号
     */
    @Id
    @Column(name = "tim_no", columnDefinition = "varchar(8) NOT NULL COMMENT '时间编号'")
    private String timNo;

    /**
     * 具体时间
     */
    @Column(name = "time", columnDefinition = "varchar(128) NOT NULL DEFAULT '' COMMENT '时间'")
    private String time;

    /**
     * 课表生成标志位
     */
    @Column(name = "mark", columnDefinition = "varchar(8) DEFAULT NULL COMMENT '标志位'")
    private String mark;

    /**
     * 节数
     */
    @Column(name = "status", columnDefinition = "tinyint(2) NOT NULL DEFAULT '2' COMMENT '节数'")
    private Short status;
}
