package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-03-22 上午11:21
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键'")
    private Integer id;

    /**
     * 课程编号
     */
    @Column(name = "cou_no", columnDefinition = "varchar(8) NOT NULL COMMENT '课程号'")
    private String couNo;

    /**
     * 课程名
     */
    @Column(name = "cou_name", columnDefinition = "varchar(128) NOT NULL COMMENT '课程名'")
    private String couName;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "created_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createdAt;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次更新时间'")
    private Date updatedAt;

}
