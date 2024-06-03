package com.system.controller;

import com.system.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
   @Resource
    private LoginService loginService;

    @GetMapping("/user/data")
    public int getDataOfSomeone(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password,
            @RequestParam(name = "identity", required = false) int identity) {
        //判断各个数据是否输入
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(identity)) {
            return 0;
        }
        //对输入的数据进行验证
        else{
            return loginService.login(username,password,identity);
        }
    }


}