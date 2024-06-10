package com.system.controller;

import com.system.pojo.Course;
import com.system.pojo.Result;
import com.system.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = {"http://ustc510.v7.idcfengye.com","http://localhost:8081","http://114.214.234.245:8081","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co:80","http://115.236.153.170:80"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class StudentController
{
    @Resource
    StudentService studentService;

    @GetMapping("/getCourses")
    public Result getCourses(@RequestParam String username, HttpServletRequest request, HttpServletResponse response)
    {
        //获得该学生选的课程

        response.setHeader("X-Content-Type-Options", "nosniff");
        //设置请求头

        if (ObjectUtils.isEmpty(username)) {return Result.error("错误！",null);}
        else
        {
            List<Course> courses = studentService.getCoursesByStudentId(username);
            if (ObjectUtils.isEmpty(courses)) {return Result.error("错误！",null);}
            else {return Result.success(courses);}
        }
    }

}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class