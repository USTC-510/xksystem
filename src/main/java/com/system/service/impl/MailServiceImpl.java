package com.system.service.impl;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl
{
    @Resource
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;
    //从配置文件中获取邮箱账号

    public String sendMail(String to,String title,String content)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        try{
            mimeMessageHelper.setTo(to); //收件人
            mimeMessageHelper.setFrom(from);//发件人
            mimeMessageHelper.setSubject(title);//题目
            mimeMessageHelper.setText(content);//内容
            javaMailSender.send(mimeMessage);//发送
            return "ok";
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return "";
    }
}
