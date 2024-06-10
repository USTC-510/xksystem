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
@CrossOrigin(origins = {"http://ustc510.v7.idcfengye.com","http://localhost:8081","http://114.214.234.245:8081","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co:80","http://115.236.153.170:80"}, methods = {RequestMethod.GET, RequestMethod.POST})
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

    @GetMapping("/ifCanCheck")
    public Result ifCanCheck(@RequestParam(name = "id") String courseId,@RequestParam(name = "username") String studentId,HttpServletResponse response,HttpServletRequest request)
    {
        //验证课程能否选择

        response.setHeader("X-Content-Type-Options", "nosniff");
        //设置请求头

        if (ObjectUtils.isEmpty(courseId) || ObjectUtils.isEmpty(studentId)) {return Result.error("错误！",null);}
        else {return Result.success(courseService.ifCanCheck(studentId,courseId));}
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AllCoursesDTO
{
    //封装响应体
    private String id;
    private String name;
    private String professor;
    private String time;
    private String position;
    private Integer credits;
    private Integer currentPeople;
    private Integer maxPeople;
    private Integer hour;
}

