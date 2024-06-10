package com.system.service;

public interface MailService
{
    int sendMail(String to,String title,String content);
    //发送邮件
}
