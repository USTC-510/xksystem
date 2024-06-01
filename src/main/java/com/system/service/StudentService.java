package com.system.service;

import com.system.mapper.StudentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;
}
