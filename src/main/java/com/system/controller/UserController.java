package com.system.controller;
import com.system.pojo.Result;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    //获得service层接口的代理

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO)
    //实现登录验证
    {
        String code = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        String identity = userLoginDTO.getIdentity();
        //获得HTTP请求的参数

        if (ObjectUtils.isEmpty(code) || ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(identity))
        {
            return Result.error("请输入账号和密码！");
        }
        //验证http请求的参数非空,否则返回错误信息

        else
        {
            int res = userService.login(code,password,identity);
            //调用service层的方法处理业务

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
@NoArgsConstructor
class UserLoginDTO
{   //这个DTO类用来封装请求体，它的属性名要与http请求的参数名一致。
    String username;
    //用户名username在后端中对应学号和工号code
    String password;
    String identity;
}
