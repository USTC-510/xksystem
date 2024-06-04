package com.system.pojo;

public class User {
    public String id; //學號 工號 也是賬戶名
    public String name;  //名字
    public String identity; //身份
    public String phonenumber;  //電話號碼
    public String password;  //登錄密碼
    public int age;  //年齡
    public String gender;  //性別

    private User(){

    }

    public User(String id, String name, String identity, String phonenumber, String password, int age, String gender) {
        this.id = id;
        this.name = name;
        this.identity = identity;
        this.phonenumber = phonenumber;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
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
