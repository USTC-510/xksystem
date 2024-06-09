package com.system;

import com.system.service.MailService;
import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.system.mapper")

//这是程序的启动类
public class Application
{
    @Resource
    MailService mailService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        int res = mailService.sendMail("haha123@mail.ustc.edu.cn","测试","测试");
    }
}
