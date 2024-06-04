package com.system.controller;
import com.system.pojo.Result;
import com.system.pojo.User;
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
    public Result login(@RequestBody User user)
    {
        String code = user.getCode();
        String password = user.getPassword();
        String identity = user.getIdentity();
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
                    return Result.error("发生了一个意外的错误");
            }
        }
    }
}
