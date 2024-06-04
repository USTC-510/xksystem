package com.system.controller;

import com.system.pojo.Result;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result loginVer(@RequestBody String id, @RequestBody String password, @RequestBody String identity)
    {
        if (ObjectUtils.isEmpty(id) || ObjectUtils.isEmpty(password))
        {
            return Result.error("请输入账号和密码！");     //验证http请求的参数非空
        }
        else
        {
            int res = userService.login(id,password,identity);
            switch (res)
            {
                case 0:
                    return Result.error("账号或密码错误！");
                case 1:
                    return Result.success(1);
                case 2:
                    return Result.success(2);
                case 3:
                    return Result.success(3);
                default:
                    return Result.error("发生了一个意外的错误");
            }
        }
    }
}
