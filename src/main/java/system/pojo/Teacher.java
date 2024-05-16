package system.pojo;

import java.util.Arrays;

public class Teacher
{
    private String name;    //姓名
    private String id;     //工号
    private char gender;   //性别
    private Faculty faculty;  //学院
    private Course[] course;  //课程
    private String password;  //登录密码
    private String phonenumber;  //电话号码
    private int age;   //年龄

    public Teacher(){

    }

    public Teacher(String name, String id, char gender, Faculty faculty, Course[] course, String password, String phonenumber, int age) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.faculty = faculty;
        this.course = course;
        this.password = password;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public char getGender() {return gender;}

    public void setGender(char gender) {this.gender = gender;}

    public Faculty getFaculty() {return faculty;}

    public void setFaculty(Faculty faculty) {this.faculty = faculty;}

    public Course[] getCourse() {return course;}

    public void setCourse(Course[] course) {this.course = course;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getPhonenumber() {return phonenumber;}

    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender=" + gender +
                ", faculty=" + faculty +
                ", course=" + Arrays.toString(course) +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age=" + age +
                '}';
    }
}
