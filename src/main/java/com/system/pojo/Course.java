package com.system.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course
{
    private String name;   //课程名字
    private String introduction;   //课程介绍
    private String[] spot;   //上课地点
    private String[] date;   //上课时间
}
