package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory = null;

    static{
        //1.定义mybatis主配置文件的名称，从类路备的根开始（target/clasess )
        String config ="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.创建sqlsessionFactory对象
         factory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static SqlSession getSqlSession() throws IOException {
        //5.获取sqlsession对象，
        SqlSession sqlSession = null;
        if(factory!=null){
            sqlSession =factory.openSession();
        }
        return sqlSession;
    }
}
