package com.system.service.impl;

import com.system.mapper.AdministratorMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TeacherMapper;
import com.system.mapper.UserMapper;
import com.system.pojo.User;
import com.system.service.MailService;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
           case "2":
               return teacherMapper.selectByCode(username);
           case "3":
               return administratorMapper.selectByCode(username);
           default:
               return null;
       }
   }

   public int changePassword(String username,String identity,String originalPassword,String newPassword)
   {
        User user = getUser(username,identity);
        if (user == null) {return 1;}
        else if (!user.getPassword().equals(originalPassword)) {return 1;}
        else
        {
            userMapper.updatePasswordByCode(identity,newPassword,username);
            return 0;
        }
   }

   public int resetPassword(String username,String title,String content)
   {
        String mail = userMapper.selectMailByUsername(username);
        if (mail != null)
        {
            String res = mailService.sendMail(mail,title,content);
            if (res.equals("ok")) {return 1;}
            else {return 0;}
        }
        else {return 0;}
   }
}
