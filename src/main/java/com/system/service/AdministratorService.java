package com.system.service;

import com.system.controller.ChangeCoursesDTO;
import com.system.pojo.Course;

public interface AdministratorService {
    int deleteCourses(String courses[]);

    int changeCourses(ChangeCoursesDTO changeCoursesDTO);

    int addCourses(Course course);
}
