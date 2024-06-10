package com.system.service.impl;

import com.system.mapper.AdministratorMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TeacherMapper;
import com.system.mapper.UserMapper;
import com.system.pojo.User;
import com.system.service.MailService;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService
{
   @Resource
   private StudentMapper studentMapper;
   @Resource
   private TeacherMapper teacherMapper;
   @Resource
   private AdministratorMapper administratorMapper;
   @Resource
   private UserMapper userMapper;
   @Resource
   private MailService mailService;


    public User getUser(String username,String identity)
    {
       switch(identity)
       {
           case "1":
               return studentMapper.selectByCode(username);
           case "student":
               return studentMapper.selectByCode(username);
           case "2":
               return teacherMapper.selectByCode(username);
           case "teacher":
               return teacherMapper.selectByCode(username);
           case "3":
               return administratorMapper.selectByCode(username);
           case "administrator":
               return administratorMapper.selectByCode(username);
           default:
               return null;
       }
    }

   public int changePassword(String username,String identity,String originalPassword,String newPassword)
   {
        User user = getUser(username,identity);
        switch(identity)
        {
            case "1":
                identity = "student";
                break;
            case "2":
                identity = "teacher";
                break;
            case "3":
                identity = "administrator";
        }
        if (ObjectUtils.isEmpty(user)) {return 1;}
        else if (!user.getPassword().equals(originalPassword)) {return 1;}
        else
        {
            userMapper.updatePasswordByCode(identity,newPassword,username);
            return 0;
        }
   }

   public String resetPasswordMail(String username,String identity)
   {
        switch(identity)
        {
           case "1":
               identity = "student";
               break;
           case "2":
               identity = "teacher";
               break;
           case "3":
               identity = "administrator";
        }

        String mail = userMapper.selectMailByCode(identity,username);
        //调用mapper找到邮箱
        String title = "找回密码";
        Random rand = new Random();

        String content = Integer.toString(rand.nextInt(9000)+1000);
        // 生成一个 1000 到 9999 之间的随机数（包括1000和9999）作为验证码

        if (mail != null)
        {
            int res = mailService.sendMail(mail,title,content);
            if (res == 1) {return content;}
            else {return null;}
        }
        else {return null;}
   }

   public void resetPassword(String username,String newPassword,String identity)
   {
       switch(identity)
       {
           case "1":
               identity = "student";
               break;
           case "2":
               identity = "teacher";
               break;
           case "3":
               identity = "administrator";
       }

       userMapper.updatePasswordByCode(identity,newPassword,username);
   }
}
