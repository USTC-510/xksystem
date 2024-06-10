package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import com.system.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
     @Resource
     CourseMapper courseMapper;

     public List<Course> getCoursesByStudentId(String code) {
        return courseMapper.getCoursesByStudentId(code);
    }

}
