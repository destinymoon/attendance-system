package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-03-25 下午10:28
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键'")
    private Integer id;

    /**
     * 课程信息
     */
    @Column(name = "sch_tab_no", columnDefinition = "varchar(40) DEFAULT NULL COMMENT '外键，对应课程信息'")
    private String schTabNo;

    /**
     * 选课学生
     */
    @Column(name = "sch_stu_no", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '外键，对应选课学生'")
    private String schStuNo;

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
