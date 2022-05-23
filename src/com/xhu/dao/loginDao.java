package com.xhu.dao;

import com.xhu.pojo.Student;
import com.xhu.pojo.User;

public interface loginDao {

    int saveUser(User user);

    User findUseByNamePass(User user);

    Student finStudByNamePass(Student student);

    int saveStud(Student student);

    int updateUser(User user);

    int updateStudent(Student student);
}
