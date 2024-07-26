package com.system.service;

import com.system.pojo.Course;
import com.system.pojo.Student;

import java.util.List;

public interface StudentService
{
    List<Course> getCoursesByStudentId(String code);
    List<Student> getAllStudents();
}
