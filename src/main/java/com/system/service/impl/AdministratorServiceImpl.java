package com.system.service.impl;

import com.system.mapper.AdministratorMapper;
import com.system.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resourse
    private AdministratorMapper administratorMapper;
    public int deleteCourses(String courses[]) {
        for (int i=0;i<courses.length;i++) {
            String code=courses[i];
            if(administratorMapper.deleteCourse(code)==1) {
                continue;
            }
            else {
                return 0;
            }
        }
        return 1;
    }
}
