package com.system.controller;

import com.system.pojo.Result;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController
{
    @Resource
    CourseService courseService;
    @GetMapping("/allCourse")
    public Result getAllCourses()
    {

    }

    @GetMapping("/detailedCourse")
    public Result getDetailedCourse()
    {
            
    }

}
