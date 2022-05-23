package com.xhu.controller;


import com.xhu.Service.impl.adminServiceImpl;
import com.xhu.pojo.Blog;
import com.xhu.pojo.Link;
import com.xhu.pojo.Note;
import com.xhu.pojo.Student;
import jdk.nashorn.internal.ir.CallNode;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminServiceImpl adminService;

    @RequestMapping("/showIndex")
    public String showIndex(){
        return "adminpage/noteManager";
    }

    @RequestMapping("/showModifyNote")
    public String showModifyNote(){
        return "adminpage/modifyNote";
    }


    @RequestMapping("/all")
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
        return "forward:showIndex";
    }

    @RequestMapping("delete.do")
    public String deleteNote(HttpServletRequest req){
        String id = req.getParameter("id");
        String pageNo = req.getParameter("pageNo");
        Boolean aBoolean = adminService.deleteNote(Integer.parseInt(id));
        return "forward:all?pageNo="+pageNo;
    }

    @RequestMapping("/searchNote")
    public String search(HttpServletRequest req){
        String note = req.getParameter("noteName");
        if(note.trim().length() == 0){
            return "forward:all";
        }
        List<Note> Notes = adminService.selectByNote(note);
        req.setAttribute("notes",Notes);

        return "forward:showIndex";
    }

    //<!--${pageContext.request.contextPath}/admin/modifyStuMsg.jsp?id=${note.id}-->
    //跳转到修改修养并显示数据

    @RequestMapping("/toModifyNote")
    public String modifyForward(HttpServletRequest req){
        String id = req.getParameter("id");
        System.out.println("id="+id);
        if(id==null) return "forward:showIndex";
        Note note = adminService.selectById(Integer.parseInt(id));
        req.setAttribute("note",note);
        System.out.println("note="+note);
        return "forward:showModifyNote";
    }


    @RequestMapping("/modifyNote.do")
    public String modifyNote(Note note,HttpServletRequest req){
        System.out.println(note);

        Boolean aBoolean = adminService.updateNote(note);
        return "forward:all";
    }

    @RequestMapping("/addNote.do")
    public String addNote(Note note){
        System.out.println(note);
        Boolean aBoolean = adminService.addNote(note);
        return "forward:all";
    }

    //====学生管理======
    @RequestMapping("/toStudManager")
    public String showStudManager(){
        return "adminpage/studentManager";
    }

    @RequestMapping("/allStud")
    public String searchAllStud(HttpServletRequest req){
        Integer pageNo = 1;
        String pageNo1 = req.getParameter("pageNo");
        if(pageNo1!=null){
            pageNo = Integer.parseInt(pageNo1);
            if(pageNo<=0) pageNo = 1;
        }

        List<Student> list = adminService.selectStudLimit((pageNo - 1) * 5);
        System.out.println(list);
        req.setAttribute("studs",list);
        req.setAttribute("pageNo",pageNo);
        return "forward:toStudManager";
    }
    @RequestMapping("/toAddStud")
    public String toAddStud(){
        return "adminpage/addStudent";
    }
    @RequestMapping("/deleteStud.do")
    public String deleteStud(HttpServletRequest req){
        String id = req.getParameter("id");
        Boolean aBoolean = adminService.deleteStud(Integer.parseInt(id));
        return "forward:allStud";
    }
    @RequestMapping("/toModifyStud")
    public String toModifyStud(HttpServletRequest req){
        String id = req.getParameter("id");
        Student student = adminService.selectOneStud(Integer.parseInt(id));
        req.setAttribute("stud",student);
        return "adminpage/modifyStuMsg";
    }

    @RequestMapping("/modifyStud")
    public String modifyStud(Student student,HttpServletRequest req){
        System.out.println(student);
        Boolean aBoolean = adminService.updateStud(student);
        if(aBoolean){
            return "forward:allStud";
        }
        return "";
    }
    @RequestMapping("/selectStuBy")
    public String selectBy(HttpServletRequest req){
        String stuName = req.getParameter("stuName");
        String sex = req.getParameter("sex");
        String gid = req.getParameter("gid");
        System.out.println(sex);
        List<Student> list = null;
        if(sex == null){
            list = adminService.selectStudBy(new Student(stuName, Integer.parseInt(gid)));
        }else {
            list = adminService.selectStudBy(new Student(stuName, Integer.parseInt(sex), Integer.parseInt(gid)));
        }

        req.setAttribute("studs",list);

        //forward:allStud
        return "forward:toStudManager";
    }

    @RequestMapping("/addStud")
    public String addStud(Student student,HttpServletRequest req){
        Boolean aBoolean = adminService.insertStud(student);
        return "forward:allStud";
    }

    //=====学习日志管理======
    @RequestMapping("/showStudBlog")
    public String showStudBlog(){
        return "adminpage/studBlog";
    }
    @RequestMapping("/selectStuBlog")
    public String selectStudBlog(HttpServletRequest req){
        int pageNo = 1;
        String pageNos = req.getParameter("pageNo");
        if(pageNos!=null){
            pageNo = Integer.parseInt(pageNos);
            if(pageNo<=1) pageNo = 1;
        }
        List<Blog> blogs = adminService.selectAllBlog((pageNo - 1) * 5);
        req.setAttribute("blogs",blogs);
        req.setAttribute("pageNo",pageNo);
        return "forward:showStudBlog";
    }
    @RequestMapping("/deleteStudBlog")
    public String deleteStudBlog(HttpServletRequest req){
        String id = req.getParameter("id");
        Boolean aBoolean = adminService.deleteBlog(Integer.parseInt(id));
        return "forward:selectStuBlog";
    }


    //====学习园地=====
    @RequestMapping("/toLinkManager")
    public String showLinkManager(){
        return "adminpage/linkManager";
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
    @RequestMapping("/deleteLink")
    public String deleteLink(HttpServletRequest req){
        String id = req.getParameter("id");
        Boolean aBoolean = adminService.deleteLink(Integer.parseInt(id));
        return "forward:selectAllLink";
    }
    @RequestMapping("/addLink")
    public String addLink(HttpServletRequest req){
        String linkName = req.getParameter("linkName");
        String link = req.getParameter("link");
        Boolean aBoolean = adminService.addLink(new Link(null, linkName, link));
        return "forward:selectAllLink";
    }
}
