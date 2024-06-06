package com.system.service.impl;

import com.system.mapper.AdministratorMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TeacherMapper;
import com.system.pojo.Administrator;
import com.system.pojo.Student;
import com.system.pojo.Teacher;
import com.system.pojo.User;
import com.system.service.UserService;
import jakarta.annotation.Resource;
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

   public User login(String code, String password, String identity)
   {
       switch(identity)
       {
           case "student":
               Student student = studentMapper.selectByCode(code);
               if (student == null) {return null;}
               else if (student.getPassword().equals(password)) {return student;}
               else {return null;}
           case "teacher":
               Teacher teacher = teacherMapper.selectByCode(code);
               if (teacher == null) {return null;}
               else if (teacher.getPassword().equals(password)) {return teacher;}
               else {return null;}
           case "administrator":
               Administrator admin = administratorMapper.selectByCode(code);
               if (admin == null) {return null;}
               else if (admin.getPassword().equals(password)) {return admin;}
               else {return null;}
           default:
               return null;
       }
   }
}
