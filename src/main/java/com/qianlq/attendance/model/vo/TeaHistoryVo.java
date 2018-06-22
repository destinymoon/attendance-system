package com.qianlq.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianliqing
 * @date 2018-04-18 下午7:55
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeaHistoryVo {

    private TimetableVo timetable;

    private AttendanceVo attendance;

    /**
     * 学生总人数
     */
    private int totalNum;

    /**
     * 签到人数
     */
    private int signNum;

    private String status;
}
