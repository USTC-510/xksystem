package com.system.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @RequestMapping("")
    public String login()
    {
        System.out.println("login");
        return "login";
    }
}
