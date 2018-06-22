package com.qianlq.attendance.repository;

import com.qianlq.attendance.entity.NoticeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-04-21 下午8:36
 * mail: 1242202279@qq.com
 */

public interface NoticeRepo extends PagingAndSortingRepository<NoticeEntity, String> {

    /**
     * 按照时间倒叙查询公告
     *
     * @return List<NoticeEntity>
     */
    List<NoticeEntity> findAllByOrderByCreatedAtDesc();
}
