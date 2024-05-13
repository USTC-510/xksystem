package entity;

public class Administrator
{
    private String name;   //姓名
    private String id;   //工号
    private char gender;  //性别
    private String password;  //登录密码

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public char getGender() {return gender;}

    public void setGender(char gender) {this.gender = gender;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {return this.name};
}
