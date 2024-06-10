package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.pojo.Course;
import com.system.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Resource
    CourseMapper courseMapper;
    public List<Course> getTeacherCourses(String code){
        return courseMapper.getCoursesByTeacherId(code);
    }

}
