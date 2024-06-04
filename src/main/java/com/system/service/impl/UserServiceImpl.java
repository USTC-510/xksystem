package com.system.service.impl;
import com.system.mapper.AdministratorMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TeacherMapper;
import com.system.pojo.Administrator;
import com.system.pojo.Student;
import com.system.pojo.Teacher;
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
   public int loginVer(String id,String password,String identity)
   {
       switch(identity)
       {
           case "student":
               Student student = studentMapper.selectById(id);
               if (student == null) {return 0;}
               else if (student.getPassword().equals(password)) {return 1;}
               else {return 0;}
           case "teacher":
               Teacher teacher = teacherMapper.selectById(id);
               if (teacher == null) {return 0;}
               else if (teacher.getPassword().equals(password)) {return 2;}
               else {return 0;}
           case "administrator":
               Administrator admin = administratorMapper.selectById(id);
               if (admin == null) {return 0;}
               else if (admin.getPassword().equals(password)) {return 3;}
               else {return 0;}
           default:
               return 0;
       }
   }
}
