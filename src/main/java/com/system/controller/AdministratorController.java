package com.system.controller;

import com.system.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
    @Resource
    private LoginService administratorService;
}
