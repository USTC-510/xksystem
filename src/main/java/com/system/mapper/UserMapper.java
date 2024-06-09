package com.system.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{

    public void updatePasswordByCode(String identity, String newPassword, String username);

}
