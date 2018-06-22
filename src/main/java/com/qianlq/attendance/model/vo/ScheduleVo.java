package com.qianlq.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianliqing
 * @date 2018-03-25 下午10:31
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleVo {

    private String tabNo;

    private String focus;

    private String course;

    private String teacher;

    private String classroom;

    private String time;

    private String mark;
}
