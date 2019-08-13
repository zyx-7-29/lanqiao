package org.taru.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.taru.Entity.User;

import java.io.IOException;
import java.io.InputStream;

public class Test2 {
    public static void main(String [] args) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //添加用户
//        User user=new User();
//        user.setUserId("4");
//        user.setUserUserName("阿里");
//        user.setUserPassword("123456");
//        int insert=sqlSession.insert("org.mybatis.example.BlogMapper.UserAdd",user);
//        System.out.println(insert);
//        sqlSession.commit();//提交事务   持久化到数据库
//        sqlSession.close();

        //根据id查找用户
//        User user =sqlSession.selectOne("org.mybatis.example.BlogMapper.findUserById",2);
//        System.out.println(user+"--llllllllllllll");
//        sqlSession.close();

        //修改用户
        User user = new User();
        user.setUserId("4");
        user.setUserUserName("baba");
        user.setUserPassword("3333");
        int uy=sqlSession.insert("org.mybatis.example.BlogMapper.UserUpdate",user);
        sqlSession.commit();
        System.out.println(uy);
        sqlSession.close();
    }

}
//如果是  增删改  必须提交事务  持久化到数据库
