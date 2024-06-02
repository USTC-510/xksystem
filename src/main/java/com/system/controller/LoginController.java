
package com.system.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    /*@Resource
    private AdministratorService administratorService;

    @GetMapping("/user/data")
    public int getDataOfSomeone(
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "password", required = false) String password,
            @RequestParam(name = "identity", required = false) int identity) {
        //判断各个数据是否输入
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password) || ObjectUtils.isEmpty(identity)) {
            return 0;
        }
        //
        if(identity==1){
            return 0;
            //学生登录
        }
        if(identity==2){
            return 0;
            //教师登录
        }
        if(identity==3){
            //管理员登录
            return administratorService.login(username,password);
        }
    }

    
*/
}