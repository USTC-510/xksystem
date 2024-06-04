package com.system.mapper;

import com.system.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper
{
    @Select("select * from teacher")
    List<Teacher> selectAll();

    @Select("select * from teacher where id = #{id}")
    Teacher selectById(String id);

    @Select("select * from teacher where name = #{name}")
    Teacher selectByName(String name);

    @Insert("insert into teacher(name,id,gender,phonenumber,password,age) values(#{name},#{id},#{gender},#{phonenumber},#{password},#{age}")
    void insertTeacher(Teacher teacher);

    @Delete("delete from teacher where id = #{id}")
    void deleteById(String id);

    @Delete("delete from teacher where name = #{name}")
    void deleteByName(String name);

    @Update("update teacher set phonenumber = #{phonenumber} where id = #{id}")
    void updatePhonenumberById(@Param("phonenumber")String phonenumber, @Param("id")String id);

    @Update("update teacher set password = #{password} where id = #{id}")
    void updatePasswordById(@Param("password")String password, @Param("id")String id);
}
