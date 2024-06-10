package com.system.service;

import com.system.controller.ChangeCoursesDTO;

public interface AdministratorService {
    int deleteCourses(String courses[]);

    int changeCourses(ChangeCoursesDTO changeCoursesDTO);
}
