package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TimeSlotMapper;
import com.system.pojo.Course;
import com.system.pojo.Student;
import com.system.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService{

     @Resource
     CourseMapper courseMapper;
     @Resource
     TimeSlotMapper timeSlotMapper;

     @Resource
     StudentMapper studentMapper;

     public List<Course> getCoursesByStudentId(String code) {

         List<Course> courses= courseMapper.getCoursesByStudentId(code);
         for(Course course:courses){
             course.setTimeSlots(timeSlotMapper.getTimeByCourseCode(course.getCode()));
         }
         return courses;
    }

    public List<Student> getAllStudents()
    {
        List<Student> students = studentMapper.selectAll();
        return students;
    }

}
