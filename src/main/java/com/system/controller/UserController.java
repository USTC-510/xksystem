package com.system.controller;

import com.system.pojo.Result;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO)
    {
        String code = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        String identity = userLoginDTO.getIdentity();
        if (ObjectUtils.isEmpty(code) || ObjectUtils.isEmpty(password))
        {
            return Result.error("请输入账号和密码！");     //验证http请求的参数非空
        }
        else
        {
            int res = userService.login(code,password,identity);
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
                    return Result.error("发生了一个意外的错误,请重试。");
            }
        }
    }
}

@Data
@AllArgsConstructor
class UserLoginDTO
{   //这个DTO类用来封装请求体
    String username;
    String password;
    String identity;
}
