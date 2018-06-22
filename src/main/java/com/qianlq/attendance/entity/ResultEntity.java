package com.qianlq.attendance.entity;

import com.qianlq.attendance.model.vo.AttendanceVo;
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
 * @date 2018-04-10 下午3:47
 * mail: 1242202279@qq.com
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "result")
@EntityListeners(AuditingEntityListener.class)
public class ResultEntity extends BaseEntity implements Comparable<ResultEntity>{

    /**
     * 主键uuid
     */
    @Id
    @GenericGenerator(name = "id_uuid", strategy = "uuid")
    @GeneratedValue(generator = "id_uuid")
    @Column(name = "res_no", columnDefinition = "varchar(40) NOT NULL COMMENT 'uuid'")
    private String resNo;

    /**
     * 具体签到信息
     */
    @Column(name = "res_att_no", columnDefinition = "varchar(40) DEFAULT NULL COMMENT '外键，对应签到记录'")
    private String resAttNo;

    /**
     * 具体课程编号
     */
    @Column(name = "res_tab_no", columnDefinition = "varchar(40) DEFAULT NULL COMMENT '外键，对应课程'")
    private String resTabNo;

    /**
     * 具体学生
     */
    @Column(name = "res_stu_no", columnDefinition = "varchar(40) NOT NULL DEFAULT '' COMMENT '外键，对应学生'")
    private String resStuNo;

    /**
     * 签到状态
     */
    @Column(name = "status", columnDefinition = "varchar(2) DEFAULT '0' COMMENT '是否签到，0未签到/1签到/2请假'")
    private String status;

    /**
     * 签到地点
     */
    @Column(name = "place", columnDefinition = "varchar(256) DEFAULT NULL COMMENT '签到地点'")
    private String place;

    /**
     * 请假理由
     */
    @Column(name = "remark", columnDefinition = "varchar(256) DEFAULT NULL COMMENT '请假理由'")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "created_at", columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createdAt;

    /**
     * 更新时间（学生签到时间）
     */
    @Column(name = "updated_at", columnDefinition = "timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次更新时间'")
    private Date updatedAt;

    /**
     * 构建签到/请假对象（所有学生状态置0/2）
     *
     * @param resAttNo
     * @param resStuNo
     * @param resStuNo
     * @param status
     */
    public ResultEntity(String resAttNo, String resTabNo, String resStuNo, String status, Date createdAt){
        this.resAttNo = resAttNo;
        this.resTabNo = resTabNo;
        this.resStuNo = resStuNo;
        this.status = status;
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(ResultEntity res) {
        return -createdAt.compareTo(res.createdAt);
    }
}
