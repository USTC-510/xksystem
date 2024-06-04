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

    @Select("select * from teacher where code = #{code}")
    Teacher selectByCode(String code);

    @Select("select * from teacher where name = #{name}")
    Teacher selectByName(String name);

    @Insert("insert into teacher(name,code,gender,phonenumber,password,age) values(#{name},#{code},#{gender},#{phonenumber},#{password},#{age}")
    void insertTeacher(Teacher teacher);

    @Delete("delete from teacher where code = #{code}")
    void deleteByCode(String code);

    @Delete("delete from teacher where name = #{name}")
    void deleteByName(String name);

    @Update("update teacher set phonenumber = #{phonenumber} where code = #{code}")
    void updatePhonenumberByCode(@Param("phonenumber")String phonenumber, @Param("code")String code);

    @Update("update teacher set password = #{password} where code = #{code}")
    void updatePasswordByCode(@Param("password")String password, @Param("code")String code);
}
