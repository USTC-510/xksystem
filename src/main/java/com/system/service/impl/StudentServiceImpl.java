package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl
{
     @Resource
     CourseMapper courseMapper;

     public List<Course> getCoursesByStudentId(String code) {
        return courseMapper.getCoursesByStudentId(code);
    }

}
