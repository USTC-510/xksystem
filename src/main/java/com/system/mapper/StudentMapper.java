package com.system.mapper;
import com.system.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper
{
    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where code = #{code}")
    Student selectByCode(String code);

    @Select("select * from student where name = #{name}")
    Student selectByName(String name);

    @Insert("insert into student(name,code,gender,phonenumber,password,age,level) values(#{name},#{code},#{gender},#{phonenumber},#{password},#{age},#{level}")
    void insertStudent(Student student);

    @Delete("delete from student where code = #{code}")
    void deleteByCode(String code);

    @Delete("delete from student where name = #{name}")
    void deleteByName(String name);

    @Update("update student set phonenumber=#{phonenumber} where code = #{code}")
    void updatePhonenumberByCode(@Param("phonenumber")String phonenumber, @Param("code")String code);

    @Update("update student set password=#{password} where code = #{code}")
    void updatePasswordByCode(@Param("password")String password, @Param("code")String code);
}
