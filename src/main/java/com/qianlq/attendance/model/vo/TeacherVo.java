package com.qianlq.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianliqing
 * @date 2018-03-24 上午9:47
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherVo {

    private String account;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String college;

    private String major;

    public TeacherVo(String name, String phone, String email, String college, String major){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.college = college;
        this.major = major;
    }
}
