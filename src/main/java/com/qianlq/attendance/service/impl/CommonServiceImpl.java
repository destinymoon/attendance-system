package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.entity.NoticeEntity;
import com.qianlq.attendance.model.vo.TeacherVo;
import com.qianlq.attendance.repository.NoticeRepo;
import com.qianlq.attendance.repository.TeacherRepo;
import com.qianlq.attendance.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-04-21 下午4:11
 * mail: 1242202279@qq.com
 */

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private NoticeRepo noticeRepo;

    /**
     * 根据教师姓名模糊查询
     *
     * @param teaName 教师姓名
     * @return BaseResult
     */
    @Override
    public BaseResult getTeaInfo(String teaName) {
        TeacherVo vo = teacherRepo.findFirstByTeaNameLike(teaName);
        return BaseResultFactory.createSuccessResult(vo);
    }

    /**
     * 查看公告
     *
     * @return BaseResult
     */
    @Override
    public BaseResult getNotice() {
        List<NoticeEntity> vos = noticeRepo.findAllByOrderByCreatedAtDesc();
        return BaseResultFactory.createSuccessResult(vos);
    }
}
