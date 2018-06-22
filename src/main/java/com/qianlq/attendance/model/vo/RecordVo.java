package com.qianlq.attendance.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianliqing
 * @date 2018-04-13 下午4:54
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
public class RecordVo {

    /**
     * 课程信息
     */
    private TimetableVo timetableVo;

    /**
     * 签到信息
     */
    private AttendanceVo attendanceVo;

    private String status;

    public RecordVo(TimetableVo timetableVo, AttendanceVo attendanceVo, String status){
        this.timetableVo = timetableVo;
        this.attendanceVo = attendanceVo;
        this.status = status;
    }
}
