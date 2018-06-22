package com.qianlq.attendance.model.vo;

import com.qianlq.attendance.common.ConstantFactory;
import com.qianlq.attendance.common.enums.Type;
import com.qianlq.attendance.entity.ResultEntity;
import lombok.*;

import java.util.Date;

/**
 * @author qianliqing
 * @date 2018-04-17 下午6:48
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {

    /**
     * 学生信息
     */
    private UserVo userVo;

    /**
     * 签到状态
     */
    private String status;

    /**
     * 学生签到时间
     */
    private Date signTime;

    public ResultVo(UserVo user, ResultEntity result) {
        this.userVo = user;
        this.status = ConstantFactory.getDesc(result.getStatus(), Type.RESULT);
        this.signTime = result.getUpdatedAt();
    }
}
