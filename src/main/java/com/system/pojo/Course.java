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
    private String date;   //上课日期
    private int number; //选课人数
    private Teacher teacher;  //教课的老师
    private String code; //课程编号，作为主键
    private String introduction; //课程介绍
    private int maxnum; //选课人数上限
    private int credit; //学分
    private int hour; //学时
    public String day;//周几上课
    public String startTime;//第几节开始上课
    public String endTime;
}
