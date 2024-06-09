package com.system.controller;

import com.system.pojo.Course;
import com.system.pojo.Result;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController
{
    @Resource
    CourseService courseService;
    @GetMapping("/allCourse")
    public Result getAllCourses()
    {
        List<Course> courses = courseService.getAllCourses();
        if (ObjectUtils.isEmpty(courses)) {return Result.error("发生了意料之外的错误",null);}
        else
        {
                
        }

    }

    @GetMapping("/detailedCourse")
    public Result getDetailedCourse()
    {

    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class allCourseDTO
{
    private String[] id;
    private String[] name;
    private String[] professor;
    private String[] time;
    private String[] position;
    private int[] creadits;
    private int[] currentPeople;
    private int[] maxPeople;
}

