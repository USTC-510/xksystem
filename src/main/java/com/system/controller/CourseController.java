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
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = {"http://localhost:1969","http://114.214.234.245:1969","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co"}, methods = {RequestMethod.GET, RequestMethod.POST})
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
            String time_whole = "";

            for (Course course: courses)
            {
                id.add(course.getCode());
                name.add(course.getName());
                professor.add(course.getTeacher().getName());
                position.add(course.getSpot());
                credit.add(course.getCredit());
                currentPeople.add(course.getNumber());
                maxPeople.add(course.getMaxnum());
                hour.add(course.getHour());
                time.add(time_whole);
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

//    @GetMapping("/ifCanCheck")
//    public Result ifCanCheck(@RequestParam String studentId,@RequestParam String courseId,HttpServletResponse response,HttpServletRequest request)
//    {
//        //验证课程能否选择
//
//
//    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AllCoursesDTO
{
    //封装响应体
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

