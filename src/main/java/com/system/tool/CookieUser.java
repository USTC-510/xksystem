package com.system.tool;

import jakarta.servlet.http.Cookie;

public class CookieUser
{
    //这是一个工具类，只有一个方法getValue，用于从Cookies中获取当前登录用户的信息
    public static String getValue(Cookie[] cookies,String name)
    {
        //参数解释：cookies需要在Controller类中使用HttpServletRequest类的getCookies方法获取，第二个参数name是你需要获取的信息名称。
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (name.equals(cookie.getName()))
                {
                   return cookie.getValue();
                }
            }
        }
        return null;
    }
}
