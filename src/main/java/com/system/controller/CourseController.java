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
            List<Integer> credits = new ArrayList<>();
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
                credits.add(course.getCredit());





            }
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
class AllCoursesDTO
{
    private List<String> id;
    private List<String> name;
    private List<String> professor;
    private List<String> time;
    private List<String> position;
    private List<Integer> credits;
    private List<Integer> currentPeople;
    private List<Integer> maxPeople;
    private List<Integer> hour;
}

