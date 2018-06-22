package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.TimetableEntity;
import com.qianlq.attendance.model.vo.TimetableVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @author qianliqing
 * @date 2018-04-10 下午8:20
 * mail: 1242202279@qq.com
 */

public interface TimetableRepo extends PagingAndSortingRepository<TimetableEntity, String> {

    /**
     * 根据课程号(tabNo)查询课程信息
     *
     * @param tabNo 课程号
     * @return TimetableEntity
     */
    TimetableEntity findByTabNo(@Param("tabNo") String tabNo);

    /**
     * 根据课程号(tabNo)查询课程详细信息
     *
     * @param tabNo 课程号
     * @return TimetableVo
     */
    @Query("SELECT new com.qianlq.attendance.model.vo.TimetableVo(cou.couName, tea.teaName, roo.rooName, tim.time) " +
            "FROM CourseEntity cou, TeacherEntity tea, ClassroomEntity roo, TimeEntity tim, TimetableEntity tab " +
            "WHERE cou.couNo = tab.tabCouNo AND tea.teaNo = tab.tabTeaNo AND roo.rooNo = tab.tabRooNo " +
            "AND tim.timNo = tab.tabTimNo AND tab.tabNo = :tabNo")
    TimetableVo findDetailByTabNo(@Param("tabNo") String tabNo);

    /**
     * 根据课程号(tabNo)查询课程详细信息
     *
     * @param tabNo 课程号
     * @param couNo
     * @return TimetableVo
     */
    @Query("SELECT new com.qianlq.attendance.model.vo.TimetableVo(cou.couName, tea.teaName, roo.rooName, tim.time) " +
            "FROM CourseEntity cou, TeacherEntity tea, ClassroomEntity roo, TimeEntity tim, TimetableEntity tab " +
            "WHERE cou.couNo = tab.tabCouNo AND tea.teaNo = tab.tabTeaNo AND roo.rooNo = tab.tabRooNo " +
            "AND tim.timNo = tab.tabTimNo AND tab.tabNo = :tabNo AND tab.tabCouNo = :couNo")
    TimetableVo findDetailByTabNoAndCouNo(@Param("tabNo") String tabNo, @Param("couNo") String couNo);

    /**
     * 根据课程号(focus)查询课程信息
     *
     * @param focus 课程号
     * @return List<TimetableVo>
     */
    @Query("SELECT new com.qianlq.attendance.model.vo.TimetableVo(tab.tabNo, cou.couName, tea.teaName, roo.rooName, tim.time) " +
            "FROM CourseEntity cou, TeacherEntity tea, ClassroomEntity roo, TimeEntity tim, TimetableEntity tab " +
            "WHERE cou.couNo = tab.tabCouNo AND tea.teaNo = tab.tabTeaNo AND roo.rooNo = tab.tabRooNo " +
            "AND tim.timNo = tab.tabTimNo AND tab.focus = :focus")
    List<TimetableVo> findByFocus(@Param("focus") String focus);
}
