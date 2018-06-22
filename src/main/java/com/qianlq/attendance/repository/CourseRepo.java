package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.CourseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:33
 * mail: 1242202279@qq.com
 */

public interface CourseRepo extends PagingAndSortingRepository<CourseEntity, String> {

    /**
     * 查询所有学院
     *
     * @return List<CourseEntity>
     */
    @Query(value = "SELECT * FROM course", nativeQuery = true)
    List<CourseEntity> findAllCourse();
}
