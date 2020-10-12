package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.example.util.MybatisUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void InsertStudent() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路备的根开始（target/clasess )
        String config ="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建了sqlsessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建sqlsessionFactory对象
        SqlSessionFactory factory = builder.build(inputStream);
        //5.获取sqlsession对象，从sqlsessionFactory中获取sqlsession
        SqlSession sqlSession = factory.openSession();
        //6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + "." ＋标签的id值
        String sqlId ="org.example.dao.StudentDao"+"."+"insertStudent";
        Student student = new Student(1004,"刘备","liu@163.com",65);
        //7．重要】执行sql语句，通过sqlId找到语句
        int insert = sqlSession.insert(sqlId, student);
        //提交事务
        sqlSession.commit();
        //8.输出结果
        System.out.println(insert);
        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void selectStudents() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        String sqlId ="org.example.dao.StudentDao"+"."+"selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        sqlSession.commit();
        for(Student student:students){
            System.out.println(student);
        }
        sqlSession.close();
    }
}
