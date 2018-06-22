package com.qianlq.attendance.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-03-19 下午2:28
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@EntityListeners({AuditingEntityListener.class})
public class TeacherEntity extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键'")
    private Integer id;

    /**
     * 教师工号
     */
    @Column(name = "tea_no", columnDefinition = "varchar(32) NOT NULL COMMENT '教工号'")
    private String teaNo;

    /**
     * 密码
     */
    @Column(name = "password", columnDefinition = "varchar(32) NOT NULL DEFAULT '123456' COMMENT '密码'")
    private String password;

    /**
     * 教师姓名
     */
    @Column(name = "tea_name", columnDefinition = "varchar(32) NOT NULL DEFAULT '' COMMENT '姓名'")
    private String teaName;

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
    @Column(name = "tea_col_no", columnDefinition = "int(8) DEFAULT NULL COMMENT '外键，学院编号'")
    private String teaColNo;

    /**
     * 具体方向
     */
    @Column(name = "tea_maj_no", columnDefinition = "int(8) DEFAULT NULL COMMENT '外键，具体方向'")
    private String teaMajNo;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "created_at", columnDefinition = "timestamp default current_timestamp comment '创建时间'")
    private Date createdAt;

    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "timestamp default current_timestamp comment '最近一次更新时间'")
    private Date updatedAt;
}
