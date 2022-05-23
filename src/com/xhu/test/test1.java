package com.xhu.test;

import com.xhu.dao.loginDao;
import com.xhu.pojo.User;
import org.apache.ibatis.session.SqlSession;

public class test1 {
    public static void main(String[] args) {
        //loginDao dao = MapperUtils.getDao(loginDao.class);
       // User root = dao.findUseByNamePass(new User("root", "123"));
        //SqlSession ss = MapperUtils.getSqlSession();

        //ss.commit(true);
//        //System.out.println(ss);
//        //int k = ss.insert("com.xhu.dao.loginDao.saveUser",new User("root1", "root"));
//        //ss.commit();
//        //ss.close();
//        loginDao mapper = ss.getMapper(loginDao.class);
//        int k=0;
//        try {
//            k = mapper.saveUser(new User("root2", "root"));
//        }catch (Exception e){
//
//        }
//        try {
//            ss.commit();
//        }catch (Exception e){
//
//        }
//
//
//        System.out.println("====");
//        MapperUtils.close();
//        System.out.println(k);

    }
}
