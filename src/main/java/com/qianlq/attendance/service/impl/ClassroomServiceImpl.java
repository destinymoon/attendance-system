package com.qianlq.attendance.service.impl;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.common.BaseResultFactory;
import com.qianlq.attendance.common.ConstantFactory;
import com.qianlq.attendance.common.enums.Status;
import com.qianlq.attendance.common.enums.Type;
import com.qianlq.attendance.entity.ClassroomEntity;
import com.qianlq.attendance.repository.ClassroomRepo;
import com.qianlq.attendance.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-03-24 上午11:10
 * mail: 1242202279@qq.com
 */

@Service
public class ClassroomServiceImpl implements ClassroomService{

    @Autowired
    private ClassroomRepo classroomRepo;

    /**
     * 查询所有空教室
     *
     * @return BaseResult
     */
    @Override
    public BaseResult getAvailableRoo() {
        String status = ConstantFactory.getStatus(Status.CLASSROOM_AVAILABLE);
        List<ClassroomEntity> entity = classroomRepo.findByStatus(status);
        if (entity !=null&&entity.size()>0){
            entity.forEach(e->{
                e.setStatus(ConstantFactory.getDesc(e.getStatus(), Type.CLASSROOM));
            });
        }
        return BaseResultFactory.createSuccessResult(entity);
    }
}
