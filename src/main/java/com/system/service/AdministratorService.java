package com.system.service;

import com.system.mapper.AdministratorMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    @Resource
    private AdministratorMapper administratorMapper;
}