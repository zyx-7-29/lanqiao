package org.taru.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.taru.Entity.User;
import org.taru.Entity.UserAM;
import org.taru.service.UserServiceImpl;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String []args) throws Exception{
//        Page page=new Page();
//        Link link=new Link();
//        DaYin dayin=new DaYin(page,link);
//        dayin.out();
//        dayin.innie();
//        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        UserServiceImpl impl= context.getBean("userServiceIm;l",UserServiceImpl.class);
//        UserAM user=impl.login("zhangsan","123456");
//        System.out.println(user);
        //加载配置文件 初始化  环境
        //获取mybatis-config.xml 文件流
        String resource ="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建工厂添加mybatis-config.xml  。sql会话工厂   工厂产生Sql Session(Connection) 一次链接数据库的过程
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build (inputStream);
        //获得session
        SqlSession sqlSession =sqlSessionFactory.openSession();//相当打开一个链接
        List<User> users =sqlSession.selectList("org.mybatis.example.BlogMapper.selectUsers");
        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
}
