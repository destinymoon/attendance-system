package com.qianlq.attendance.model.vo;

import lombok.*;

/**
 * @author qianliqing
 * @date 2018-04-10 下午5:17
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    private String name;

    private String college;

    private String major;

    private String clazz;

    private String phone;

    public UserVo(StudentVo vo) {
        this.name = vo.getName();
        this.college = vo.getCollege();
        this.major = vo.getMajor();
        this.clazz = vo.getClazz();
    }

    public UserVo(TeacherVo vo) {
        this.name = vo.getName();
        this.college = vo.getCollege();
        this.major = vo.getMajor();
    }
}
