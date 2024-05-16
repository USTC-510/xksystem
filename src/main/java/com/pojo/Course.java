package com.pojo;

public class Course
{
    private String name;   //课程名字
    private String introduction;   //课程介绍
    private String[] spot;   //上课地点
    private String[] date;   //上课时间
    private Teacher[] teachers;  //授课教师
    private Student[] students;  //参与学生
    private Faculty[] facultys;  //开设学院

    public Course(){

    }

    public Course(String name, String introduction, String[] spot, String[] date, Teacher[] teachers, Student[] students, Faculty[] facultys) {
        this.name = name;
        this.introduction = introduction;
        this.spot = spot;
        this.date = date;
        this.teachers = teachers;
        this.students = students;
        this.facultys = facultys;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getIntroduction() {return introduction;}

    public void setIntroduction(String introduction) {this.introduction = introduction;}

    public String[] getSpot() {return spot;}

    public void setSpot(String[] spot) {this.spot = spot;}

    public String[] getDate() {return date;}

    public void setDate(String[] date) {this.date = date;}

    public Teacher[] getTeachers() {return teachers;}

    public void setTeachers(Teacher[] teachers) {this.teachers = teachers;}

    public Student[] getStudents() {return students;}

    public void setStudents(Student[] students) {this.students = students;}

    public Faculty[] getFacultys() {return facultys;}

    public void setFacultys(Faculty[] facultys) {this.facultys = facultys;}

    @Override
    public String toString() {return this.name;}
}
