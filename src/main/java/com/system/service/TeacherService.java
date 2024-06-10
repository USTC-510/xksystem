package com.system.service;

import com.system.pojo.Course;

import java.util.List;

public interface TeacherService
{
    List<Course> getTeacherCourses(String code);
}
