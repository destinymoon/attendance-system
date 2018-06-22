package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.ResultEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author qianliqing
 * @date 2018-04-10 下午8:12
 * mail: 1242202279@qq.com
 */

public interface ResultRepo extends PagingAndSortingRepository<ResultEntity, String> {

    /**
     * 根据学号(stuNo)查询
     *
     * @param stuNo     学号
     * @param time      时间
     * @param status    签到情况
     * @param attStatus 签到是否被取消
     * @return ResultEntity
     */
    @Query(value = "SELECT res FROM ResultEntity res WHERE res.resStuNo = :stuNo AND res.status = :status AND res.createdAt < :time AND resAttNo IN " +
            "(SELECT att.attNo FROM AttendanceEntity att WHERE att.timeout > :time AND att.status = :attStatus)")
    ResultEntity findByStuNoAndStatusAndTime(@Param("stuNo") String stuNo, @Param("time") Date time, @Param("status") String status, @Param("attStatus") String attStatus);

    /**
     * 根据学号(stuNo)和签到编号(attNo)签到信息
     *
     * @param stuNo 学号
     * @param attNo 签到编号
     * @return ResultEntity
     */
    ResultEntity findByResStuNoAndResAttNo(@Param("stuNo") String stuNo, @Param("attNo") String attNo);

    /**
     * 根据学号(stuNo)查询签到信息
     *
     * @param stuNo  学号
     * @param status 签到是否取消
     * @param time   时间
     * @param date   当前时间
     * @return List<BaseResult>
     */
    @Query("SELECT res FROM ResultEntity res, AttendanceEntity att WHERE res.resStuNo = :stuNo AND res.resAttNo = att.attNo AND att.status <> :status AND res.createdAt > :time AND res.createdAt < :date")
    List<ResultEntity> findByResStuNoOrderByCreatedAtDesc(@Param("stuNo") String stuNo, @Param("status") String status, @Param("time") Date time, @Param("date") Date date);

    /**
     * 根据签到编号(attNo)查询签到信息
     *
     * @param attNo 签到编号
     * @return List<BaseResult>
     */
    List<ResultEntity> findByResAttNo(@Param("attNo") String attNo);

    /**
     * 获取签到学生人数
     *
     * @param attNo 签到编号
     * @return int
     */
    int countByResAttNo(@Param("attNo") String attNo);

    /**
     * 获取签到学生人数
     *
     * @param attNo  签到编号
     * @param status 状态
     * @return int
     */
    int countByResAttNoAndStatus(@Param("attNo") String attNo, @Param("status") String status);

    /**
     * 获取学生签到/请假的总次数
     *
     * @param stuNo     学号
     * @param tabNo     课程编号
     * @param status    状态
     * @param attStatus 状态
     * @return int
     */
    @Query("SELECT COUNT (res) FROM ResultEntity res, AttendanceEntity att WHERE res.resStuNo = :stuNo AND res.resTabNo = :tabNo " +
            "AND res.status = :status AND res.resAttNo = att.attNo AND att.status <> :attStatus")
    int countByResStuNoAndResTabNoAndStatus(@Param("stuNo") String stuNo, @Param("tabNo") String tabNo, @Param("status") String status, @Param("attStatus") String attStatus);

}
