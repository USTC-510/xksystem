package com.system.mapper;

import com.system.pojo.Administrator;
import com.system.pojo.TimeSlot;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorMapper
{
    //管理员信息的增删改查
    @Select("select * from administrator")
    List<Administrator> selectAll();
    @Select("select * from administrator where code = #{code}")
    Administrator selectByCode(String code);

    @Select("select * from administrator where name = #{name}")
    Administrator selectByName(String name);

    @Insert("insert into administrator(name,code,gender,phonenumber,password,age) values(#{name},#{code},#{gender},#{phonenumber},#{password},#{age})")
    void insertAdministrator(Administrator administrator);

    @Delete("delete from administrator where code = #{code}")
    void deleteByCode(String code);

    @Delete("delete from administrator where name = #{name}")
    void deleteByName(String name);

    @Delete("delete from course where code = #{code}")
    int deleteCourse(String code);


    @Update("update administrator set phonenumber = #{phonenumber} where code = #{code}")
    void updatePhonenumberByCode(@Param("phonenumber")String phonenumber, @Param("code")String code);

    @Update("update administrator set password = #{password} where code = #{code}")
    void updatePasswordByCode(@Param("password")String password, @Param("code")String code);

    @Update("update course set name=#{name} credit=#{credit} hour=#{hour} spot=#{spot} teacher=#{teacher} maxnum=#{maxnum} where code=#{code}")
    void changeNameByCode(@Param("code")String code,@Param("name")String name,@Param("credit")Integer credit,@Param("hour")Integer hour,@Param("spot")String spot,@Param("teacher")String teacher,@Param("maxnum")Integer maxnum);

    void changeTimeByCode(@Param("code")String code, @Param("timeSlot")List<TimeSlot> timeSlot);
}
