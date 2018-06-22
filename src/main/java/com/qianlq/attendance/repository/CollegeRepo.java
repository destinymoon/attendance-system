package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.CollegeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-22 下午1:35
 * mail: 1242202279@qq.com
 */

public interface CollegeRepo extends PagingAndSortingRepository<CollegeEntity, String> {

    /**
     * 查询所有学院
     *
     * @return
     */
    @Query(value = "SELECT * FROM college", nativeQuery = true)
    List<CollegeEntity> findAllCollege();
}
