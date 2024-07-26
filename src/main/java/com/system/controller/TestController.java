package com.system.controller;

import com.system.pojo.Result;
import com.system.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//测试用，随时删。
@RestController
@RequestMapping("/api/test")
@CrossOrigin
public class TestController
{
    @Resource
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public Result getAllStudents()
    {
        return Result.success(studentService.getAllStudents());
    }
}
