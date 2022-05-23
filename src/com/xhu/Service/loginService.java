package com.xhu.Service;

import com.xhu.pojo.Student;
import com.xhu.pojo.User;

public interface loginService {
    /**
     * 注册管理员用户
     * @param user
     * @return
     */
    Boolean saveUser(User user);

    /**
     * 查询（根据user和pass）登录
     * @param user
     * @return
     */
    User findUseByNamePass(User user);

    /**
     * 查询（根据user和pass）登录
     * @param student
     * @return
     */
    Student findStudByNamePass(Student student);

    /**
     * 注册学生用户
     * @param student
     * @return
     */
    Boolean saveStud(Student student);


    Boolean updateUser(User user);

    Boolean updateStudent(Student student);
}
