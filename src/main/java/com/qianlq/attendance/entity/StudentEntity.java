package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-03-19 下午2:04
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class StudentEntity extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键'")
    private Integer id;

    /**
     * 学号
     */
    @Column(name = "stu_no", columnDefinition = "varchar(32) unsigned NOT NULL COMMENT '学号'")
    private String stuNo;

    /**
     * 密码
     */
    @Column(name = "password", columnDefinition = "varchar(32) NOT NULL DEFAULT '123456' COMMENT '密码'")
    private String password;

    /**
     * 学生姓名
     */
    @Column(name = "stu_name", columnDefinition = "varchar(32) NOT NULL DEFAULT '' COMMENT '姓名'")
    private String stuName;

    /**
     * 性别
     */
    @Column(name = "sex", columnDefinition = "tinyint(2) DEFAULT '0' COMMENT '性别'")
    private Short sex;

    /**
     * 联系方式
     */
    @Column(name = "phone", columnDefinition = "varchar(11) NOT NULL COMMENT '手机号码'")
    private String phone;

    /**
     * 电子邮箱
     */
    @Column(name = "email", columnDefinition = "varchar(64) DEFAULT NULL COMMENT '电子邮箱'")
    private String email;

    /**
     * 学院编号
     */
    @Column(name = "stu_col_no", columnDefinition = "varchar(8) DEFAULT NULL COMMENT '外键，学院编号'")
    private String stuColNo;

    /**
     * 专业编号
     */
    @Column(name = "stu_maj_no", columnDefinition = "varchar(8) DEFAULT NULL COMMENT '外键，专业编号'")
    private String stuMajNo;

    /**
     * 班级
     */
    @Column(name = "stu_class", columnDefinition = "int(8) DEFAULT NULL COMMENT '班级'")
    private String stuClass;

    /**
     * 创建时间
     */
    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp comment '创建时间'")
    private Date createdAt;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp comment '最近一次更新时间'")
    private Date updatedAt;
}
