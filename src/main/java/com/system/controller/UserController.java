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
@CrossOrigin(origins = {"http://localhost:1969","http://114.214.234.245:1969","http://localhost:8080","http://114.214.234.245:8080","http://92o66n2830.goho.co"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Resource
    private UserService userService;
    //获得service层接口的代理

    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response) {
        //实现登录验证

        String code = loginDTO.getUsername();
        String identity = loginDTO.getIdentity();
        String password = loginDTO.getPassword();
        //获得HTTP请求的参数

        if (ObjectUtils.isEmpty(code) || ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(identity)) {
            return Result.error("请输入账号和密码！", "notFound");
        }
        //验证http请求的参数非空,否则返回错误信息

        else {
            User user = userService.getUser(code,identity);
            //调用service层的方法获得当前用户的信息

            response.setHeader("X-Content-Type-Options", "nosniff");
            //设置请求头

            if (user == null) {return Result.error("账号错误！", "notFound");}
            else if(!user.getPassword().equals(password)) {return Result.error("密码错误！","notFound");}
            else {return Result.success(user.getIdentity());}
        }
    }

    @GetMapping("/realName")
    public Result realName(@RequestParam String username, @RequestParam String identity, HttpServletRequest request, HttpServletResponse response) {
        //获取当前用户的姓名

        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(identity)) {return Result.error("发生了意料之外的错误！", "notFound");}
        //检查请求非空
        String name = userService.getUser(username, identity).getName();
        //调用service获取结果
        response.setHeader("X-Content-Type-Options", "nosniff");
        //设置请求头
        if (name != null) {return Result.success(name);}
        else {return Result.error("请输入正确的用户名或身份！", "notFound");}
    }

    @GetMapping("/getInfor")
    public Result getInfor(@RequestParam String username,@RequestParam String identity,HttpServletRequest request,HttpServletResponse response)
    {
        //获取当前用户的各项信息

        User user = userService.getUser(username,identity);
        //调用service的方法
        response.setHeader("X-Content-Type-Options", "nosniff");
        //设置请求头
        if (user != null) {return Result.success(user);}
        else {return Result.error("请输入正确的用户名或身份！","notFound");}
    }

//    @PostMapping("/changePassword")
//    public Result changePassword(@RequestBody ChangePasswordDTO dto,HttpServletRequest request,HttpServletResponse response)
//    {
//        //修改密码
//
//        String username = dto.getUsername();
//        String identity = dto.getIdentity();
//        String originalPassword = dto.getOriginalPassword();
//        String newPassword = dto.getNewPassword();
//        //获取请求体中的参数
//    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class LoginDTO
{
    private String username;
    private String password;
    private String identity;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ChangePasswordDTO
{
    private String username;
    private String identity;
    private String originalPassword;
    private String newPassword;
}
