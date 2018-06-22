package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.AttendanceEntity;
import com.qianlq.attendance.model.vo.AttendanceVo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author qianliqing
 * @date 2018-04-10 下午8:15
 * mail: 1242202279@qq.com
 */

public interface AttendanceRepo extends PagingAndSortingRepository<AttendanceEntity, String>, JpaSpecificationExecutor<AttendanceEntity> {

    /**
     * 根据签到编号(attNo)查询签到信息
     *
     * @param attNo 签到编号
     * @return AttendanceEntity
     */
    AttendanceEntity findAllByAttNo(@Param("attNo") String attNo);

    /**
     * 根据签到编号(attNo)查询签到信息
     *
     * @param attNo 签到编号
     * @return AttendanceVo
     */
    @Query("SELECT new com.qianlq.attendance.model.vo.AttendanceVo(att.attNo, att.attTabNo, att.createdAt, att.timeout, att.place, att.longitude, att.latitude, att.remark) " +
            "FROM AttendanceEntity att WHERE att.attNo = :attNo")
    AttendanceVo findByAttNo(@Param("attNo") String attNo);


    /**
     * 根据教工号(teaNo)查询签到记录
     *
     * @param teaNo 教工号
     * @param time  时间
     * @return List<AttendanceVo>
     */
    @Query("SELECT new com.qianlq.attendance.model.vo.AttendanceVo(att.attNo, att.attTabNo, att.createdAt, att.timeout, att.place, att.remark, att.status) " +
            "FROM AttendanceEntity att WHERE att.attTeaNo = :teaNo AND att.createdAt > :time")
    List<AttendanceVo> findByAttTeaNoOrderByCreatedAtDesc(@Param("teaNo") String teaNo, @Param("time") Date time);

    /**
     * 获取课程发布签到的次数
     *
     * @param tabNo  课程表编号
     * @param status 状态
     * @return int
     */
    int countByAttTabNoAndStatusNot(@Param("tabNo") String tabNo, @Param("status") String status);
}
