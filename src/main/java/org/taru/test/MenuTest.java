package org.taru.test;

import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.taru.Entity.User;
import org.taru.controller.Menu;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MenuTest {
    public static void main(String [] args) throws IOException {
        String resource ="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build (inputStream);
        //获得session
        SqlSession sqlSession =sqlSessionFactory.openSession();//相当打开一个链接
        List menus =sqlSession.selectList("org.mybatis.example.BlogMapper.SelectMenu");
        //释放资源
        Gson json=new Gson();
        String s = json.toJson(menus);
        System.out.println(s);
        sqlSession.close();
    }
}
