package com.system.controller;

import com.system.pojo.Result;
import com.system.service.AdministratorService;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/administrator")
public class AdministratorController
{
    @Resource
    AdministratorService administratorService;

    @PostMapping("/changeCourse")
    public Result changeCourse(@RequestBody ChangeCoursesDTO dto)
    {
        //管理员修改课程信息

        if (ObjectUtils.isEmpty(dto)) {return Result.error("错误！",null);}
        else {return Result.success(administratorService.changeCourses(dto));}
    }
}



