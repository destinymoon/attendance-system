package com.qianlq.attendance;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author qianliqing
 * @date 2018-03-15 下午2:54
 * mail: 1242202279@qq.com
 */

@EnableJpaAuditing
@ServletComponentScan
@EnableTransactionManagement
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class AttendanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}
}


