package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.ScheduleEntity;
import com.qianlq.attendance.entity.TimetableEntity;
import com.qianlq.attendance.model.vo.ScheduleVo;
import com.qianlq.attendance.model.vo.StudentVo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-24 下午7:55
 * mail: 1242202279@qq.com
 */

public interface ScheduleRepo extends PagingAndSortingRepository<ScheduleEntity, String>, JpaSpecificationExecutor<TimetableEntity> {

    /**
     * 根据学号(stuNo)查询学生课表
     *
     * @param account 学号
     * @return List<ScheduleVo>
     */
    @Query(value = "SELECT new com.qianlq.attendance.model.vo.ScheduleVo(tab.tabNo, tab.focus, cou.couName, tea.teaName, roo.rooName, tim.time, tim.mark) " +
            "FROM CourseEntity cou, TeacherEntity tea, ClassroomEntity roo, TimeEntity tim, TimetableEntity tab " +
            "WHERE cou.couNo = tab.tabCouNo AND tea.teaNo = tab.tabTeaNo AND roo.rooNo = tab.tabRooNo AND tim.timNo = tab.tabTimNo " +
            "AND tab.tabNo IN (SELECT sch.schTabNo FROM ScheduleEntity sch WHERE sch.schStuNo = :account)")
    List<ScheduleVo> findByTabStuNo(@Param("account") String account);

    /**
     * 根据教工号(teaNo)查询教师课表
     *
     * @param account 教工号
     * @return List<ScheduleVo>
     */
    @Query(value = "SELECT new com.qianlq.attendance.model.vo.ScheduleVo(tab.tabNo, tab.focus, cou.couName, tea.teaName, roo.rooName, tim.time, tim.mark) " +
            "FROM TimetableEntity tab, CourseEntity cou, TeacherEntity tea, ClassroomEntity roo, TimeEntity tim " +
            "WHERE tab.tabCouNo = cou.couNo AND tab.tabTeaNo = tea.teaNo AND tab.tabRooNo = roo.rooNo AND tab.tabTimNo = tim.timNo " +
            "AND tab.tabTeaNo = :account")
    List<ScheduleVo> findByTabTeaNo(@Param("account") String account);

    /**
     * 根据课程编号(tabNo)查询课程所有上课学生
     *
     * @param tabNo 课程编号
     * @return List<StudentVo>
     *
     * TODO: 当 stu.stuMajNo == NULL 时SQL语句有问题
     */
    @Query(value = "SELECT new com.qianlq.attendance.model.vo.StudentVo(stu.stuNo, stu.stuName, stu.phone, stu.email, col.colName, maj.majName, stu.stuClass) " +
            "FROM StudentEntity stu, CollegeEntity col, MajorEntity maj WHERE (stu.stuColNo = col.colNo OR stu.stuColNo = NULL) " +
            "AND (stu.stuMajNo = maj.majNo OR stu.stuMajNo = NULL) AND stu.stuNo IN (SELECT sch.schStuNo FROM ScheduleEntity sch " +
            "WHERE sch.schTabNo = :tabNo)")
    List<StudentVo> findByTabNo(@Param("tabNo") String tabNo);
}
