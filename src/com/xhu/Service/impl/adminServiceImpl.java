package com.xhu.Service.impl;

import com.xhu.Service.adminService;
import com.xhu.dao.adminDao;
import com.xhu.pojo.Blog;
import com.xhu.pojo.Link;
import com.xhu.pojo.Note;
import com.xhu.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@EnableTransactionManagement
@Service
public class adminServiceImpl implements adminService {
    @Resource(name="ssf")
    private SqlSessionFactory ssf;

    @Override
    public List<Note> selectLimit(int pageNo) {
        SqlSession ss = ssf.openSession();


//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        System.out.println(pageNo);
//        List<Note> notes = dao.selectLimit(pageNo);
//        MapperUtils.close();
        return ss.selectList("com.xhu.dao.adminDao.selectLimit",pageNo);
    }

    @Override
    public List<Note> selectByNote(String note) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        List<Note> notes = dao.selectByNote(note);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.selectList("com.xhu.dao.adminDao.selectByNote",note);
    }

    @Override
    public Boolean deleteNote(int id) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.deleteNote(id);
//        MapperUtils.close();
        //k>0?true:false
        SqlSession ss = ssf.openSession();
        return ss.delete("com.xhu.dao.adminDao.deleteNote",id)>0?true:false;
    }

    @Override
    public Boolean updateNote(Note note) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.updateNote(note);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.update("com.xhu.dao.adminDao.updateNote",note)>0?true:false;
    }

    @Override
    public Boolean addNote(Note note) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.addNote(note);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.insert("com.xhu.dao.adminDao.addNote",note)>0?true:false;
    }

    @Override
    public Note selectById(int id) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        Note note = dao.selectById(id);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.selectOne("com.xhu.dao.adminDao.selectById",id);
    }

    @Override
    public List<Student> selectStudLimit(int pageNo) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        List<Student> list = dao.selectStudLimit(pageNo);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.selectList("com.xhu.dao.adminDao.selectStudLimit",pageNo);
    }

    @Override
    public List<Student> selectStudBy(Student student) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        List<Student> list = dao.selectStudBy(student);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.selectList("com.xhu.dao.adminDao.selectStudBy",student);
    }

    @Override
    public Boolean insertStud(Student student) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.insertStud(student);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();

        return ss.insert("com.xhu.dao.adminDao.insertStud",student)>0?true:false;
    }

    @Override
    public Boolean updateStud(Student student) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.updateStud(student);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.update("com.xhu.dao.adminDao.updateStud",student)>0?true:false;
    }

    @Override
    public Boolean deleteStud(int id) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.deleteStud(id);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.delete("com.xhu.dao.adminDao.deleteStud",id)>0?true:false;
    }

    @Override
    public Student selectOneStud(int id) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        Student student = dao.selectOneStud(id);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.selectOne("com.xhu.dao.adminDao.selectOneStud",id);
    }

    @Override
    public List<Blog> selectAllBlog(int pageNo) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        List<Blog> blogs = dao.selectAllBlog(pageNo);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.selectList("com.xhu.dao.adminDao.selectAllBlog",pageNo);
    }

    @Override
    public Boolean deleteBlog(int id) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.deleteBlog(id);
//        MapperUtils.close();
        SqlSession ss = ssf.openSession();
        return ss.delete("com.xhu.dao.adminDao.deleteBlog",id)>0?true:false;
    }

    @Override
    public Boolean addBlog(Blog blog) {
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        int k = dao.addBlog(blog);
//        MapperUtils.close();

        SqlSession ss = ssf.openSession();
        return ss.insert("com.xhu.dao.adminDao.addBlog",blog)>0?true:false;
    }

    @Override
    public List<Blog> selectBlogBy(int sid, int pageNo) {
        List<Blog> blogs= ssf.openSession().getMapper(adminDao.class).selectBlogBy(sid,pageNo);
//        adminDao dao = MapperUtils.getDao(adminDao.class);
//        List<Blog> blogs = dao.selectBlogBy(sid,pageNo);
//        MapperUtils.close();
        return blogs;
    }

    @Override
    public Blog selectBlog(int id) {
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        Blog blog = dao.selectBlog(id);
        return blog;
    }



    @Override
    public List<Link> selectAllLink(int pageNo) {
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        //adminDao dao = MapperUtils.getDao(adminDao.class);
        List<Link> links = dao.selectAllLink(pageNo);
        return links;
    }

    @Override
    public Boolean deleteLink(int id) {
       // adminDao dao = MapperUtils.getDao(adminDao.class);
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        int k = dao.deleteLink(id);
        return k>0?true:false;
    }

    @Override
    public Boolean addLink(Link link) {
        //adminDao dao = MapperUtils.getDao(adminDao.class);
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        int k = dao.addLink(link);
        return k>0?true:false;
    }

    @Override
    public List<Link> selectLinkBy(String linkName) {
        //adminDao dao = MapperUtils.getDao(adminDao.class);
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        List<Link> links = dao.selectLinkBy(linkName);
        return links;
    }

    @Override
    public List<Blog> selectBlogByName(String title,int sid,int pageNo) {
        //adminDao dao = MapperUtils.getDao(adminDao.class);
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        List<Blog> blogs = dao.selectBlogByName(title,sid,pageNo);
        return blogs;
    }

    @Override
    public Boolean updateBlog(Blog blog) {
        //adminDao dao = MapperUtils.getDao(adminDao.class);
        adminDao dao = ssf.openSession().getMapper(adminDao.class);
        int k = dao.updateBlog(blog);
        return k>0?true:false;
    }
}
