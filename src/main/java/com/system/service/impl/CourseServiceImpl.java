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
   private CourseMapper courseMapper;

   public List<Course> getAllCourses()
   {
       List<Course> courses = courseMapper.selectAll();
       if (ObjectUtils.isEmpty(courses)) {return null;}
       else {return courses;}
   }

   public Course getCourseByName(String name)
   {
        Course course = courseMapper.selectByName(name);
        if (ObjectUtils.isEmpty(course)) {return null;}
        else {return course;}
   }
}
