package com.qianlq.attendance.model.vo;

import lombok.*;

import java.util.List;

/**
 * @author qianliqing
 * @date 2018-05-26 下午1:56
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryVo {

    /**
     * 发布签到的总次数(默认不包括取消的次数)
     */
    private Integer totalNum;

    /**
     * 课程信息
     */
    private TimetableVo timetableVo;

    /**
     * 学生的签到情况
     */
    private List<StuSummaryVo> stuSummary;
}
