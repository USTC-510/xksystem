package com.system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = {"http://ustc510.v7.idcfengye.com","http://localhost:8081","http://114.214.234.245:8081","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co:80","http://115.236.153.170:80"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class StudentController
{
//    @Resource
//    StudentService studentService;
//
//    @GetMapping("/getCourses")
//    public Result getCourses(@RequestParam String username, HttpServletRequest request, HttpServletResponse response)
//    {
//        //获得该学生选的课程
//
//        response.setHeader("X-Content-Type-Options", "nosniff");
//        //设置请求头
//
//
//    }


}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//class