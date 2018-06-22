package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.TeacherEntity;
import com.qianlq.attendance.model.vo.TeacherVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-19 下午2:29
 * mail: 1242202279@qq.com
 */

public interface TeacherRepo extends PagingAndSortingRepository<TeacherEntity, String> {

    /**
     * 根据账号查询个人基本信息
     *
     * @param account 教工号
     * @return TeacherEntity
     */
    TeacherEntity findByTeaNo(@Param("account") String account);

    /**
     * 根据账号查询个人详细信息
     *
     * @param account 教工号
     * @return TeacherVo
     */
    @Query(value = "SELECT new com.qianlq.attendance.model.vo.TeacherVo(tea.teaNo, tea.password, tea.teaName, tea.phone, tea.email, col.colName, maj.majName) " +
            "FROM TeacherEntity tea, CollegeEntity col, MajorEntity maj WHERE (tea.teaColNo = col.colNo OR tea.teaColNo = NULL) " +
            "AND (tea.teaMajNo = maj.majNo OR tea.teaMajNo = NULL) AND tea_no = :account")
    TeacherVo findDetailByTeaNo(@Param("account") String account);

    /**
     * 根据账号密码登录
     *
     * @param account  教工号
     * @param password 密码
     * @return TeacherEntity
     */
    TeacherEntity findByTeaNoAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 根据教师姓名模糊查询
     *
     * @param teaName 教师姓名
     * @return TeacherVo
     */
    @Query(value = "SELECT new com.qianlq.attendance.model.vo.TeacherVo(tea.teaName, tea.phone, tea.email, col.colName, maj.majName) " +
            "FROM TeacherEntity tea, CollegeEntity col, MajorEntity maj WHERE (tea.teaColNo = col.colNo OR tea.teaColNo = NULL) " +
            "AND (tea.teaMajNo = maj.majNo OR tea.teaMajNo = NULL) AND tea.teaName LIKE CONCAT('%',:teaName,'%')")
    TeacherVo findFirstByTeaNameLike(@Param("teaName") String teaName);
}
