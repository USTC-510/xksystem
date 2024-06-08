package com.system.controller;

import com.system.pojo.Result;
import com.system.pojo.User;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://115.236.153.170","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Resource
    private UserService userService;
    //获得service层接口的代理

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request, HttpServletResponse response) {
        //实现登录验证

        String code = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        String identity = userLoginDTO.getIdentity();
        //获得HTTP请求的参数

        if (ObjectUtils.isEmpty(code) || ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(identity)) {
            return Result.error("请输入账号和密码！", "notFound");
        }
        //验证http请求的参数非空,否则返回错误信息

        else {
            User this_User = userService.login(code, password, identity);
            //调用service层的方法获得当前用户的信息

            response.setHeader("X-Content-Type-Options", "nosniff");
            //设置请求头

            if (this_User == null) {
                return Result.error("账号或密码错误！", "notFound");
            } else {
                return Result.success(this_User.getIdentity());
            }
        }
    }

    @GetMapping("/realName")
    public Result realName(@RequestParam String username, @RequestParam String identity, HttpServletRequest request, HttpServletResponse response) {
        //获取当前用户的姓名

        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(identity)) {return Result.error("发生了意料之外的错误！", "notFound");}
        //检查请求非空

        String name = userService.realName(username, identity);
        //调用service获取结果
        if (name != null) {return Result.success(name);}
        else {return Result.error("请输入正确的用户名或身份！", "notFound");}
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class UserLoginDTO
{
    //这个DTO类用来封装请求体，它的属性名要与http请求的参数名一致。
    String username;
    //用户名username在后端中对应学号和工号code
    String password;
    String identity;
}
