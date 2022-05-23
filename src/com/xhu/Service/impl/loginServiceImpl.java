package com.xhu.Service.impl;

import com.xhu.Service.loginService;
import com.xhu.dao.loginDao;
import com.xhu.pojo.Student;
import com.xhu.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional(rollbackFor = Exception.class)
@EnableTransactionManagement
@Service
public class loginServiceImpl implements loginService {
    @Resource(name="ssf")
    private SqlSessionFactory ssf;
    @Override
    public Boolean saveUser(User user) {
        loginDao dao = ssf.openSession().getMapper(loginDao.class);
        //loginDao dao = MapperUtils.getDao(loginDao.class);
        int k = 0;
        try{
            k = dao.saveUser(user);
        }catch (Exception e){
            System.out.println("插入失败！！");
        }finally {
            return k>0?true:false;
        }
    }

    @Override
    public User findUseByNamePass(User user) {
        System.out.println(user);
       // loginDao dao = MapperUtils.getDao(loginDao.class);
        loginDao dao = ssf.openSession().getMapper(loginDao.class);
        User user1 = dao.findUseByNamePass(user);
        System.out.println(user1);
        return user1;
    }

    @Override
    public Student findStudByNamePass(Student student) {
        System.out.println(student);
        //loginDao dao = MapperUtils.getDao(loginDao.class);
        loginDao dao = ssf.openSession().getMapper(loginDao.class);
        Student student1 = dao.finStudByNamePass(student);
        System.out.println(student1);
        return student1;
    }

    @Override
    public Boolean saveStud(Student student) {
        loginDao dao = ssf.openSession().getMapper(loginDao.class);
        // loginDao dao = MapperUtils.getDao(loginDao.class);
        int k = 0;
        try {
            k = dao.saveStud(student);
        }catch (Exception e){
            System.out.println("student插入失败！！！");
        }finally {
            return k>0?true:false;
        }
    }

    @Override
    public Boolean updateUser(User user) {
        //loginDao dao = MapperUtils.getDao(loginDao.class);
        loginDao dao = ssf.openSession().getMapper(loginDao.class);
        int k = 0;
        try {
            k = dao.updateUser(user);
        }catch (Exception e){
            System.out.println("修改user失败！");
        }finally {
            return k>0?true:false;
        }
    }

    @Override
    public Boolean updateStudent(Student student) {
        //loginDao dao = MapperUtils.getDao(loginDao.class);
        loginDao dao = ssf.openSession().getMapper(loginDao.class);
        int k = 0;
        try {
            k = dao.updateStudent(student);
        }catch (Exception e){
            System.out.println("student修改失败！！！");
        }finally {
            return k>0?true:false;
        }
    }

}
