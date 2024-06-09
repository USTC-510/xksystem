package com.system.controller;

import com.system.pojo.Course;
import com.system.pojo.Result;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController
{
    @Resource
    CourseService courseService;
    @GetMapping("/allCourse")
    public Result getAllCourses(HttpServletResponse response, HttpServletRequest request)
    {
        //获取所有课程的所有信息

        response.setHeader("X-Content-Type-Options", "nosniff");
        //设置请求头

        List<Course> courses = courseService.getAllCourses();
        if (ObjectUtils.isEmpty(courses)) {return Result.error("发生了意料之外的错误",null);}
        //验证非空
        else
        {
            AllCoursesDTO dto = new AllCoursesDTO();
            List<String> id = new ArrayList<>();
            List<String> name = new ArrayList<>();
            List<String> professor = new ArrayList<>();
            List<String> time = new ArrayList<>();
            List<String> position = new ArrayList<>();
            List<Integer> credit = new ArrayList<>();
            List<Integer> currentPeople = new ArrayList<>();
            List<Integer> maxPeople = new ArrayList<>();
            List<Integer> hour = new ArrayList<>();

            for (Course course: courses)
            {
                id.add(course.getCode());
                name.add(course.getName());
                professor.add(course.getTeacher().getName());
                time.add(course.getDate());
                position.add(course.getSpot());
                credit.add(course.getCredit());
                currentPeople.add(course.getNumber());
                maxPeople.add(course.getMaxnum());
                hour.add(course.getHour());
            }



            dto.setId(id);
            dto.setName(name);
            dto.setCredit(credit);
            dto.setHour(hour);
            dto.setCurrentPeople(currentPeople);
            dto.setPosition(position);
            dto.setTime(time);
            dto.setMaxPeople(maxPeople);
            dto.setProfessor(professor);
            //封装数据到DTO类

            return Result.success(dto);
            //再度封装
        }
    }

    @GetMapping("/detailedCourse")
    public Result getIntro(@RequestParam(name = "course")String name,HttpServletResponse response,HttpServletRequest request)
    {
       //查找课程的介绍

        response.setHeader("X-Content-Type-Options", "nosniff");
        //设置请求头

        if (ObjectUtils.isEmpty(name)) {return Result.error("错误!",null);}
        //验证参数非空
        else
        {
            List<Course> courses = courseService.getCourseByName(name);
            //调用service

            if (ObjectUtils.isEmpty(courses)) {return Result.error("错误",null);}
            else {return Result.success(courses.get(0).getIntroduction());}
        }
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AllCoursesDTO
{
    private List<String> id;
    private List<String> name;
    private List<String> professor;
    private List<String> time;
    private List<String> position;
    private List<Integer> credit;
    private List<Integer> currentPeople;
    private List<Integer> maxPeople;
    private List<Integer> hour;
}
