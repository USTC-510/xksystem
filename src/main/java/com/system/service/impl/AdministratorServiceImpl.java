package com.system.service.impl;

import com.system.mapper.AdministratorMapper;
import com.system.service.AdministratorService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Resource
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
