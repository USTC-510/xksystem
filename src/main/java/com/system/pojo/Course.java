package com.system.pojo;

public class Course
{
    private String name;   //课程名字
    private String introduction;   //课程介绍
    private String[] spot;   //上课地点
    private String[] date;   //上课时间

    public Course(){

    }

    public Course(String name, String introduction, String[] spot, String[] date) {
        this.name = name;
        this.introduction = introduction;
        this.spot = spot;
        this.date = date;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getIntroduction() {return introduction;}

    public void setIntroduction(String introduction) {this.introduction = introduction;}

    public String[] getSpot() {return spot;}

    public void setSpot(String[] spot) {this.spot = spot;}

    public String[] getDate() {return date;}

    public void setDate(String[] date) {this.date = date;}

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", spot=" + Arrays.toString(spot) +
                ", date=" + Arrays.toString(date) +
                '}';
    }
}
