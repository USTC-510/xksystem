package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public int id; //在数据库中的主键
    public String code; //学号 工号
    public String name;  //名字
    public String identity; //身份
    public String phonenumber;  //電話號碼
    public String password;  //登錄密碼
    public int age;  //年齡
    public String gender;  //性別
    public String mail;  //邮箱
}
