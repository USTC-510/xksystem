package com.system.pojo;
public class Student extends User {
    private int level;  //年级

    public Student(String id, String name, String identity, String phonenumber, String password, int age, String gender, int level) {
        super(id, name, identity, phonenumber, password, age, gender);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

