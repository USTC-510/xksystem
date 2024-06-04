package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
public class User {
    public String id; //學號 工號 也是賬戶名
    public String name;  //名字
    public String identity; //身份
    public String phonenumber;  //電話號碼
    public String password;  //登錄密碼
    public int age;  //年齡
    public String gender;  //性別
}
