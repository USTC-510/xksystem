package com.system.mapper;

import com.system.pojo.Administrator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorMapper {
    @Select("select * from administrator")
    List<Administrator> selectAll();
    @Select("select * from administrator where id = #{id}")
    Administrator selectById(String id);

    @Select("select * from administrator where name = #{name}")
    Administrator selectByName(String name);

    @Insert("insert into administrator(name,id,gender,phonenumber,password,age) values(#{name},#{id},#{gender},#{phonenumber},#{password},#{age})")
    void insertAdministrator(Administrator administrator);

    @Delete("delete from administrator where id = #{id}")
    void deleteById(String id);

    @Delete("delete from administrator where name = #{name}")
    void deleteByName(String name);

    @Update("update administrator set phonenumber = #{phonenumber} where id = #{id}")
    void updatePhonenumberById(@Param("phonenumber")String phonenumber, @Param("id")String id);

    @Update("update administrator set password = #{password} where id = #{id}")
    void updatePasswordById(@Param("password")String password, @Param("id")String id);
}
