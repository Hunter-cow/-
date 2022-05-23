package com.xhu.dao;

import com.xhu.pojo.Blog;
import com.xhu.pojo.Link;
import com.xhu.pojo.Note;
import com.xhu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface adminDao {
    public List<Note> selectLimit(int pageNo);
    public List<Note> selectByNote(String note);
    public int deleteNote(int id);
    public int updateNote(Note note);
    public int addNote(Note note);
    public Note selectById(int id);


    public List<Student> selectStudLimit(int pageNo);
    public List<Student> selectStudBy(Student student);
    public int insertStud(Student student);
    public int updateStud(Student student);
    public int deleteStud(int id);
    public Student selectOneStud(int id);


    public List<Blog> selectAllBlog(int pageNo);
    public int deleteBlog(int id);
    public int addBlog(Blog blog);
    public List<Blog> selectBlogBy(@Param("sid") int sid,@Param("pageNo") int pageNo);
    public Blog selectBlog(int id);
    public List<Blog> selectBlogByName(@Param("title") String title,@Param("sid") int sid,@Param("pageNo") int pageNo);
    public int updateBlog(Blog blog);


    public List<Link> selectAllLink(int pageNo);
    public int deleteLink(int id);
    public int addLink(Link link);
    public List<Link> selectLinkBy(String linkName);

}
