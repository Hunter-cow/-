package com.xhu.Service;

import com.xhu.pojo.Blog;
import com.xhu.pojo.Link;
import com.xhu.pojo.Note;
import com.xhu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface adminService {
    public List<Note> selectLimit(int pageNo);
    public List<Note> selectByNote(String note);
    public Boolean deleteNote(int id);
    public Boolean updateNote(Note note);
    public Boolean addNote(Note note);
    public Note selectById(int id);

    public List<Student> selectStudLimit(int pageNo);
    public List<Student> selectStudBy(Student student);
    public Boolean insertStud(Student student);
    public Boolean updateStud(Student student);
    public Boolean deleteStud(int id);
    public Student selectOneStud(int id);



    public List<Blog> selectAllBlog(int pageNo);
    public Boolean deleteBlog(int id);
    public Boolean addBlog(Blog blog);
    public List<Blog> selectBlogBy(int sid, int pageNo);
    public Blog selectBlog(int id);
    public List<Blog> selectBlogByName(String title,int sid,int pageNo);
    public Boolean updateBlog(Blog blog);

    public List<Link> selectAllLink(int pageNo);
    public Boolean deleteLink(int id);
    public Boolean addLink(Link link);
    public List<Link> selectLinkBy(String linkName);
}
