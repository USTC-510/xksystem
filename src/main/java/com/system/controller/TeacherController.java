package com.system.controller;

import com.system.pojo.Course;
import com.system.pojo.Result;
import com.system.service.CourseService;
import com.system.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin(origins = {"http://ustc510.v7.idcfengye.com","http://localhost:8081","http://114.214.234.245:8081","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co:80","http://115.236.153.170:80"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class TeacherController
{
    @Resource
    TeacherService teacherService;
    @Resource
    CourseService courseService;

    @GetMapping("/getCourses")
    public Result getCourses(@RequestParam String username)
    {
        //获得老师教授的课程信息


        List<Course> courses = teacherService.getTeacherCourses(username);
        AllCoursesDTO dto = new AllCoursesDTO();
        List<AllCoursesDTO> dtoList = new ArrayList<>();

        if (ObjectUtils.isEmpty(courses)) {return Result.error("发生了意料之外的错误",null);}
        //验证非空
        else
        {
            for (Course course: courses)
            {
                dto.setName(course.getName());
                dto.setCredits(course.getCredit());
                dto.setHour(course.getHour());
                dto.setId(course.getCode());
                dto.setPosition(course.getSpot());
                dto.setMaxPeople(course.getMaxnum());
                dto.setProfessor(course.getTeacher());
                dto.setCurrentPeople(course.getNumber());
                dto.setTime(courseService.connectTime(course));
                dtoList.add(dto);
            }
            return Result.success(dtoList);
            //再度封装
        }
    }
}
