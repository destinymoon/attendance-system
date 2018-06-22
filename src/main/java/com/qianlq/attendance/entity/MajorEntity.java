package com.qianlq.attendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:18
 * mail 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "major")
public class MajorEntity extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键'")
    private Integer id;

    /**
     * 专业编号
     */
    @Column(name = "maj_no", columnDefinition = "varchar(8) NOT NULL COMMENT '专业编号'")
    private String majNo;

    /**
     * 专业名
     */
    @Column(name = "maj_name", columnDefinition = "varchar(128) NOT NULL DEFAULT '' COMMENT '专业名'")
    private String majName;

    /**
     * 专业对应学院
     */
    @Column(name = "maj_col_no", columnDefinition = "varchar(8) DEFAULT NULL COMMENT '外键，对应学院编号'")
    private String majColNo;
}
