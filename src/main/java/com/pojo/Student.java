package com.pojo;

public class Student {
    private String name;    //姓名
    private String id;     //学号
    private char gender;   //性别
    private com.Faculty faculty;  //学院
    private com.Course[] course;  //课程
    private String password;  //登录密码
    private String phonenumber;   //电话号码
    private int age;   //年龄
    private int level;  //年级

    public Student(){

    }

    public Student(String name, String id, char gender, com.Faculty faculty, com.Course[] course, String password, String phonenumber, int age, int level) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.faculty = faculty;
        this.course = course;
        this.password = password;
        this.phonenumber = phonenumber;
        this.age = age;
        this.level = level;
    }

    //下面是每个属性的get和set方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public com.Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public com.Course[] getCourse() {
        return course;
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {return phonenumber;}

    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public int getLevel() {return level;}

    public void setLevel(int level) {this.level = level;}


    @Override
    public String toString() {return this.name;}
}

