package com.system;
import com.system.pojo.*;
import com.system.mapper.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import java.util.List;


public class MybatisDemo
{
    public static void main(String[] args) throws IOException
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession =  sqlSessionFactory.openSession();

        //List<Student> students = sqlSession.selectList("test:selectAll");
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.selectAll();

        System.out.println(students);
        sqlSession.close();
    }
}
