package com.qianlq.attendance.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author qianliqing
 * @date 2018-04-18 下午8:51
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuHistoryVo {

    private TimetableVo timetable;

    private AttendanceVo attendance;

    /**
     * 签到状态
     */
    private String status;
}
