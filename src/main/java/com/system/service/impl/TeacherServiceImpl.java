package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.mapper.TeacherMapper;
import com.system.pojo.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl
{
    @Resource
    CourseMapper courseMapper;
    public List<Course> getCoursesByTeacherId(String code){
        return courseMapper.getCoursesByTeacherId(code);
    }

}
