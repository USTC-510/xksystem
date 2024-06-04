package com.system.service;

public interface UserService
{
   int loginVer(String id,String password,String identity);
    //用户的登录验证。
    //前端需要在参数中包含账户名（我们使用学号和工号id作为账户名），密码password和身份identity（student，teacher或administrator）
    // 返回值：0 -> 错误,并返回错误信息，前端需要在页面上展示错误信息，1 -> 学生， 2 -> 老师, 3 -> 管理员
    //对应controller的访问地址是：/login/loginVer

}
