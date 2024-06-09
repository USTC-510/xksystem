package com.system.service;

import com.system.pojo.User;

public interface UserService
{
   User getUser(String username,String identity);
   int changePassword(String username,String identity,String originalPassword,String newPassword);
}
