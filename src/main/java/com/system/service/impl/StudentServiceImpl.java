package com.system.service.impl;

import com.system.mapper.CourseMapper;
import com.system.mapper.TimeSlotMapper;
import com.system.pojo.Course;
import com.system.pojo.TimeSlot;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  StudentServiceImpl
{
     @Resource
     CourseMapper courseMapper;
     @Resource
    TimeSlotMapper timeSlotMapper;

     public List<Course> getCoursesByStudentId(String code) {

         List<Course> courses= courseMapper.getCoursesByStudentId(code);
         for(Course course:courses){
             course.setTimeSlots(timeSlotMapper.getTimeByCourseCode(course.getCode()));
         }
         return courses;
    }

}
