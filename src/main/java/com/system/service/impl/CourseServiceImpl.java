package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import com.system.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
   @Resource
    CourseMapper courseMapper;

    public List<Course> getAllCourses()
    {
        List<Course> courses = courseMapper.selectAll();
        if (ObjectUtils.isEmpty(courses)) {return null;}
        else {return courses;}
    }

    public List<Course> getCourseByName(String name)
    {
        List<Course> courses = courseMapper.selectByName(name);
        if (ObjectUtils.isEmpty(courses)) {return null;}
        else {return courses;}
    }

    public List<Course> getCoursesByStudentId(int code)
    {
        return courseMapper.getCoursesByStudentId(code);
    }
}
