package com.system.service;

import com.system.pojo.Course;

import java.util.List;

public interface CourseService
{
    List<Course> getAllCourses();

    Course getCourseByName(String name);
}
