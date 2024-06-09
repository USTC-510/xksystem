package com.system.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
    private String name;   //课程名字
    private String spot;   //上课地点
    private String date;   //上课时间
    private int number; //选课人数
    private Student[] students;  //选课的学生们
    private Teacher[] teachers;  //教课的老师们
    private String code; //课程编号，作为主键
    private String introduction; //课程介绍
    private int maxnum; //选课人数上限    
}
