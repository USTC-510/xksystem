package com.system;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.system.mapper")

//这是程序的启动类
public class Application
{
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
//        EmailSender emailSender = new EmailSender();
//        emailSender.sendEmailTo("1520131241@qq.com","zkr230527@mail.ustc.edu.cn","th051014","niaho","nihao");
    }
}
