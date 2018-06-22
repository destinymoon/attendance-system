package com.qianlq.attendance.model.vo;

import lombok.*;

/**
 * @author qianliqing
 * @date 2018-03-24 下午12:47
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimetableVo {

    private String tabNo;

    private String course;

    private String teacher;

    private String classroom;

    private String time;

    public TimetableVo(String course, String teacher, String classroom, String time) {
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
        this.time = time;
    }
}
