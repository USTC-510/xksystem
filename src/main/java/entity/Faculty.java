package entity;

public class Faculty
{
    private String name;   //学院名
    private Course[] courses;  //开设课程

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Course[] getCourses() {return courses;}

    public void setCourses(Course[] courses) {this.courses = courses;}

    @Override
    public String toString() {return this.name;};
}
