package com.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{

   void updatePasswordByCode(@Param("tableName")String identity, @Param("newPassword")String newPassword, @Param("username")String code);

   String selectMailByCode(@Param("tableName")String identity,@Param("code")String code);

}
