package com.qianlq.attendance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-04-21 下午8:37
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notice")
public class NoticeEntity {

    /**
     * Mysql 自带 uuid
     */
    @Id
    @Column(name = "not_no", columnDefinition = "varchar(40) NOT NULL COMMENT 'uuid'")
    private String notNo;

    /**
     * 标题
     */
    @Column(name = "title", columnDefinition = "varchar(64) DEFAULT NULL COMMENT '标题'")
    private String title;

    /**
     * 内容
     */
    @Column(name = "content", columnDefinition = "varchar(256) DEFAULT NULL COMMENT '内容'")
    private String content;

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
