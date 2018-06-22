package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.MajorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-22 下午3:23
 * mail: 1242202279@qq.com
 */

public interface MajorRepo extends PagingAndSortingRepository<MajorEntity, String> {

    /**
     * 查询学院所有专业
     *
     * @param colNo 学院编号
     * @return List<MajorEntity>
     */
    List<MajorEntity> findByMajColNo(@Param("colNo") String colNo);
}
