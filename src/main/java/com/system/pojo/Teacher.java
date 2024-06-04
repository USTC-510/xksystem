package com.system.pojo;

public class Teacher extends User
{
    public Teacher(String id, String name, String identity, String phonenumber, String password, int age, String gender) {
        super(id, name, identity, phonenumber, password, age, gender);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
