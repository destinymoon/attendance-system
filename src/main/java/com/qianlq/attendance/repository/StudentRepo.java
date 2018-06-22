package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.StudentEntity;
import com.qianlq.attendance.model.vo.StudentVo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author qianliqing
 * @date 2018-03-19 下午1:56
 * mail: 1242202279@qq.com
 */

public interface StudentRepo extends PagingAndSortingRepository<StudentEntity, String>, JpaSpecificationExecutor<StudentEntity> {

    /**
     * 根据账号查询个人基本信息
     *
     * @param account 学号
     * @return StudentEntity
     */
    StudentEntity findByStuNo(@Param("account") String account);

    /**
     * 根据账号查询个人详细信息
     *
     * @param account 学号
     * @return StudentVo
     */
    @Query(value = "SELECT new com.qianlq.attendance.model.vo.StudentVo(stu.stuNo, stu.stuName, stu.phone, stu.email, col.colName, maj.majName, stu.stuClass) " +
            "FROM StudentEntity stu, CollegeEntity col, MajorEntity maj WHERE (stu.stuColNo = col.colNo OR stu.stuColNo = NULL) " +
            "AND (stu.stuMajNo = maj.majNo OR stu.stuMajNo = NULL) AND stu_no = :account")
    StudentVo findDetailByStuNo(@Param("account") String account);

    /**
     * 根据账号密码登录
     *
     * @param account  学号
     * @param password 密码
     * @return StudentEntity
     */
    StudentEntity findByStuNoAndPassword(@Param("account") String account, @Param("password") String password);
}
