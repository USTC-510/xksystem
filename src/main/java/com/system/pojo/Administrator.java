package com.system.pojo;

public class Administrator extends User
{
    public Administrator(String id, String name, String identity, String phonenumber, String password, int age, String gender) {
        super(id, name, identity, phonenumber, password, age, gender);
    }

    @Override
    public String toString() {
        return "Administrator{" +
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
