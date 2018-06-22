package com.qianlq.attendance.test;

import com.qianlq.attendance.common.BaseResult;
import com.qianlq.attendance.service.TeacherService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qianliqing
 * @date 2018-04-17 下午8:23
 * mail: 1242202279@qq.com
 */

@Component
public class TimeTests {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void test() {
        BaseResult result = teacherService.getResult("8a09822c62c746900162c74a6b770000");
        System.out.println(result);
    }
}
