package com.system.controller;

import com.system.pojo.Result;
import com.system.pojo.User;
import com.system.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://114.214.234.245:8080", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UserController
{
    @Resource
    private UserService userService;
    //获得service层接口的代理


    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session, HttpServletRequest request, HttpServletResponse response)
    //实现登录验证
    {
        String code = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        String identity = userLoginDTO.getIdentity();
        //获得HTTP请求的参数

        if (ObjectUtils.isEmpty(code) || ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(identity))
        {
            return Result.error("请输入账号和密码！","notFound");
        }
        //验证http请求的参数非空,否则返回错误信息

        else
        {
            User this_User = userService.login(code,password,identity);
            //调用service层的方法获得当前用户的信息

            response.setHeader("X-Content-Type-Options", "nosniff");
            //设置响应头

            if (this_User == null){return Result.error("账号或密码错误！","notFound");}
            else
            {
                session.setAttribute("user",this_User);
                return Result.success(this_User.getIdentity());
            }
        }
    }

    @PostMapping("/realName")
    public Result realName(HttpSession session)
    {
        //获取当前用户的名字
        User this_User = (User) session.getAttribute("user");
        if (this_User != null)
        {
            return Result.success(this_User.getName());
        }
        return Result.error("用户未登录！","notFound");
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
