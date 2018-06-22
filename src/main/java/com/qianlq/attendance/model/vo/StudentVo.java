package com.qianlq.attendance.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qianliqing
 * @date 2018-03-23 下午11:54
 * mail: 1242202279@qq.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVo {

    private String account;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String college;

    private String major;

    private String clazz;

    public StudentVo(String account, String name, String phone, String email, String college, String major, String clazz){
        this.account = account;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.college = college;
        this.major = major;
        this.clazz = clazz;
    }
}
