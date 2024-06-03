package com.system.service;
import com.system.mapper.AdministratorMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TeacherMapper;
import com.system.pojo.Administrator;
import com.system.pojo.Student;
import com.system.pojo.Teacher;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {

    @Resource
    private AdministratorMapper administratorMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    public int login(String id, String password, int identity) {
        if(identity==1){
            //学生登录
            List<Student> list=studentMapper.selectbyId(id);
            if(list!=null && !list.isEmpty()){
                Student student=list.get(0);
                if(password.equals(student.getPassword())) {
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        else if(identity==2){
            //教师登录
            List<Teacher> list=teacherMapper.selectById(id);
            if(list!=null&&!list.isEmpty()){
                Teacher teacher=list.get(0);
                if(password.equals(teacher.getPassword())) {
                    return 2;
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        else if(identity==3){
            //管理员登录
            List<Administrator> list= administratorMapper.selectById(id);
            if(list!=null&&!list.isEmpty()){
                Administrator administrator=list.get(0);
                if(password.equals(administrator.getPassword())) {
                    return 3;
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
}