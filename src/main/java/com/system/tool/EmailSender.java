package com.system.tool;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public void sendEmailTo(String from, String to, String password,String title,String content)
    {
        //这个静态方法能发送邮件
        //参数解释：from是发件人的邮箱，to是收件人的邮箱，password是发件人邮箱的密码，title是邮件标题，content是邮件内容

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.qq.com"); // 你的SMTP服务器地址
        properties.put("mail.smtp.port", "587"); // 或者使用其他端口，如465（SSL）
        //properties.put("mail.smtp.socketFactory.port", "465"); // 设置 SSL 端口
        //properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // 设置 SSL Socket Factory
        //properties.put("mail.smtp.socketFactory.fallback", "false"); // 禁用 SSL 回退

        // 获取默认session对象
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
                // 在这里填写发送邮件的邮箱地址和密码/授权码
            }
        });

        try {
            // 创建邮件消息
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from)); // 设置发件人邮箱
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // 设置收件人邮箱
            message.setSubject(title); // 设置邮件主题
            message.setText(content); //设置邮件内容
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}


