package com.xhu.test;

import com.xhu.Service.impl.adminServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("com/xhu/config/applicationContext.xml");
//        SqlSessionFactoryBean ssfb = (SqlSessionFactoryBean)ac.getBean("sqlSessionFactory");
//        System.out.println(ssfb);
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/xhu/config/applicationContext.xml");

        adminServiceImpl admin = (adminServiceImpl)ac.getBean("adminServiceImpl");
        System.out.println(admin);

//        loginDao mapper = sqlSession.getMapper(loginDao.class);
//        User root = mapper.findUseByNamePass(new User("root", "123"));
//        System.out.println(root.getUsername());
        //DataSource dataSource = (DataSource)ac.getBean("dataSource");
        //System.out.println(dataSource);
    }
}
