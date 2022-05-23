package com.xhu.controller;

import com.xhu.Service.impl.adminServiceImpl;
import com.xhu.pojo.Blog;
import com.xhu.pojo.Link;
import com.xhu.pojo.Note;
import com.xhu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class studentController {
    @Autowired
    private adminServiceImpl adminService;
    @RequestMapping("/toStudNoteManager")
    public String showIndex(){
        return "studentpage/studentNoteManager";
    }

    @RequestMapping("/selectAllNote")
    public String searchAll(HttpServletRequest req){
        String pageNos = req.getParameter("pageNo");
        int pageNo = 1;
        if(pageNos != null){
            pageNo = Integer.parseInt(pageNos);
            if(pageNo<=0) pageNo = 1;
        }
        List<Note> Notes = adminService.selectLimit((pageNo-1)*5);

        System.out.println(Notes);
        req.setAttribute("notes",Notes);
        req.setAttribute("pageNo",pageNo);
        return "forward:toStudNoteManager";
    }

    @RequestMapping("/searchNote")
    public String search(HttpServletRequest req){
        String note = req.getParameter("noteName");
        if(note.trim().length() == 0){
            return "forward:selectAllNote";
        }
        List<Note> Notes = adminService.selectByNote(note);
        req.setAttribute("notes",Notes);
        return "forward:toStudNoteManager";
    }

    @RequestMapping("/toStudBlog")
    public String showStudBlog(){
        return "studentpage/studentBlog";
    }


    @RequestMapping("/selectBlogBy")
    public String selectBlogBy(HttpServletRequest req){
        int pageNo = 1;
        String pageNos = req.getParameter("pageNo");
        if(pageNos!=null){
            pageNo = Integer.parseInt(pageNos);
            if(pageNo<=1) pageNo = 1;
        }
        Student student = (Student)req.getSession().getAttribute("student");
        List<Blog> blogs = adminService.selectBlogBy(Integer.parseInt(student.getCode()),(pageNo-1)*5);
        req.setAttribute("blogs",blogs);
        req.setAttribute("pageNo",pageNo);
        return "forward:toStudBlog";
    }

    @RequestMapping("/deleteStudBlog")
    public String deleteStudBlog(HttpServletRequest req){
        String id = req.getParameter("id");
        Boolean aBoolean = adminService.deleteBlog(Integer.parseInt(id));
        return "forward:selectBlogBy";
    }
    @RequestMapping("/addBlog")
    public String addBlog(HttpServletRequest req){
        String blogName = req.getParameter("blogName");
        String blogCover = req.getParameter("blogCover");
        String sid = req.getParameter("sid");
        Boolean aBoolean = adminService.addBlog(new Blog(blogName, blogCover, Integer.parseInt(sid)));
        return "forward:selectBlogBy";
    }
    @RequestMapping("/selectBlogById")
    public String selectBlog(HttpServletRequest req){
        String id = req.getParameter("id");
        Blog blog = adminService.selectBlog(Integer.parseInt(id));
        req.setAttribute("blog",blog);
        return "forward:toModifyBlog";
    }
    @RequestMapping("/selectBlogByName")
    public String searchBlog(HttpServletRequest req){
        int pageNo = 1;
        String pageNos = req.getParameter("pageNo");
        if(pageNos!=null){
            pageNo = Integer.parseInt(pageNos);
            if(pageNo<=1) pageNo = 1;
        }
        Student student = (Student)req.getSession().getAttribute("student");
        String title = req.getParameter("noteName");
        List<Blog> blogs = adminService.selectBlogByName(title, Integer.parseInt(student.getCode()), (pageNo-1)*5);
        req.setAttribute("blogs",blogs);
        req.setAttribute("pageNo",pageNo);
        return "forward:toStudBlog";
    }
    @RequestMapping("/toModifyBlog")
    public String toModifyBlog(HttpServletRequest req){
        return "studentpage/modifyStudBlog";
    }
    @RequestMapping("/updateBlog")
    public String modifyBlog(Blog blog,HttpServletRequest req){
        System.out.println(blog);
        Boolean aBoolean = adminService.updateBlog(blog);
        return "redirect:selectBlogBy";
    }

    //====新增blog
    @RequestMapping("/toAddBlog")
    public String toAddBlog(){
        return "studentpage/addBlog";
    }


    //=====tolinkManager
    @RequestMapping("/toLinkManager")
    public String toLinkManager(){
        return "studentpage/linkManager";
    }

    @RequestMapping("/selectAllLink")
    public String selectAllLink(HttpServletRequest req){
        int pageNo = 1;
        String pageNos = req.getParameter("pageNo");
        if(pageNos!=null){
            pageNo = Integer.parseInt(pageNos);
            if(pageNo<=1) pageNo = 1;
        }
        List<Link> links = adminService.selectAllLink((pageNo - 1) * 5);
        req.setAttribute("links",links);
        req.setAttribute("pageNo",pageNo);
        return "forward:toLinkManager";
    }
    @RequestMapping("/selectLinkBy")
    public String selectLinkBy(HttpServletRequest req){
        String linkName = req.getParameter("linkName");
        List<Link> links = adminService.selectLinkBy(linkName);
        req.setAttribute("links",links);
        return "forward:toLinkManager";
    }

}
