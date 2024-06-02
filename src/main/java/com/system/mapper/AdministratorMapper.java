package com.system.mapper;

import com.system.pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorMapper {

    List<Administrator> selectById(@Param("username")String username);
}
