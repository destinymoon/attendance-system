package com.qianlq.attendance.model.vo;

import com.qianlq.attendance.entity.CourseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


/**
 * @author qianliqing
 * @date 2018-05-26 下午2:03
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuSummaryVo {

    /**
     * 学生信息
     */
    private UserVo userVo;

    /**
     * 签到次数
     */
    private Integer signNum;

    /**
     * 请假次数
     */
    private Integer leaveNum;
}
