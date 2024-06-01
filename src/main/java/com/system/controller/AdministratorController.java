package com.system.controller;

import com.system.service.AdministratorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Resource
    private AdministratorService administratorService;
}
