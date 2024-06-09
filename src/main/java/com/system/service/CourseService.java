package com.system.service;
import com.system.pojo.Course;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    List<Course> getCourseByName(String name);

    List<Course> getCoursesByStudentId(String code);

    int ifCanCheck(String studentcode,String coursecode);
}
