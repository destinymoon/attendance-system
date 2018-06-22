package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.ClassroomEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @author qianliqing
 * @date 2018-03-24 上午11:05
 * mail: 1242202279@qq.com
 */

public interface ClassroomRepo extends PagingAndSortingRepository<ClassroomEntity, String> {

    /**
     * 查询所有教室
     *
     * @param status 状态
     * @return List<ClassroomEntity>
     */
    List<ClassroomEntity> findByStatus(@Param("status") String status);
}
