package com.xhu.controller;

import com.xhu.Service.impl.loginServiceImpl;
import com.xhu.pojo.Student;
import com.xhu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/login")
public class loginController {
    @Autowired
    private loginServiceImpl loginService;

    @RequestMapping("/show")
    public String ShowLogin(){
        System.out.println("login");
        return "login";
    }
    @RequestMapping("/register")
    public String ShowRegister(){
        return "register";
    }

    @RequestMapping("/doRegister")
    public String save(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String state = req.getParameter("state");
        System.out.println(state);
        if(state!= null){
            if(state.equals("sysUser")){
                User user = new User(username,password);
                Boolean aBoolean = loginService.saveUser(user);
                if(aBoolean){
                    req.getSession().setAttribute("user",user);
                    return "redirect:admin/all";
                }
            }else{
                Student student = new Student(username,password);
                Boolean aBoolean = loginService.saveStud(student);
                if(aBoolean){
                    req.getSession().setAttribute("student",student);
                    return "studentpage/studentNoteManager";
                }
            }
        }
        return "login";
    }
    @RequestMapping("/doLogin")
    public String doLoginIn(HttpServletRequest req){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String state = req.getParameter("state");
        System.out.println(state);
        if(state!= null){
            if(state.equals("sysUser")){
                User usr = new User(username,password);
                User useByNamePass = loginService.findUseByNamePass(usr);
                if(useByNamePass!=null){
                    req.getSession().setAttribute("user",useByNamePass);
                    return "redirect:/admin/all";
                }
            }else{
                Student student = new Student(username,password);
                Student student1 = loginService.findStudByNamePass(student);
                if(student1!=null){
                    req.getSession().setAttribute("student",student1);
                    return "studentpage/studentNoteManager";
                }
            }
        }
        return "login";
    }
    @RequestMapping("/modifyPass")
    public String modifyPass(HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        String currPass = req.getParameter("currPass");
        String newPass = req.getParameter("newPass");
        user.setPassword(newPass);
        Boolean aBoolean = loginService.updateUser(user);
        if(aBoolean){
            System.out.println("修改成功");
            req.getSession().setAttribute("user","");
        }
        return "login";
    }
    @RequestMapping("/modifyPassStud")
    public String modifyPassStud(HttpServletRequest req){
        Student student = (Student)req.getSession().getAttribute("student");
        String currPass = req.getParameter("currPass");
        String newPass = req.getParameter("newPass");
        student.setPassword(newPass);
        Boolean aBoolean = loginService.updateStudent(student);
        if(aBoolean){
            System.out.println("修改成功");
            req.getSession().setAttribute("student","");
        }
        return "login";
    }


    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest req){
        req.getSession().setAttribute("user","");
        req.getSession().setAttribute("student","");
        return "login";
    }

    @GetMapping ("/createCode")
    public void createCode(HttpServletRequest req, HttpServletResponse resp){
        int width = 120;
        int height = 40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics g1 = image.getGraphics();
        g1.setColor(getRandColor(200,250));
        g1.fillRect(0,0,width-1,height-1);
        Graphics2D g2d = (Graphics2D) g1;
        g2d.setFont(new Font("宋体",Font.BOLD,18));

        List<String> words = getWords(req.getServletContext());
        Random random = new Random();
        int index = random.nextInt(words.size());
        String word = words.get(index);
        int x = 10;
        for (int i = 0; i < word.length(); i++) {
            g2d.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),random.nextInt(110)));
            int jiaodu = random.nextInt(60)-30;
            double theta = jiaodu + Math.PI/180;
            char c = word.charAt(i);
            g2d.rotate(theta,x,20);
            g2d.drawString(String.valueOf(c),x,20);
            g2d.rotate(-theta,x,20);
            x += 30;
        }
        g1.setColor(getRandColor(160,200));
        int x1,x2,y1,y2;
        for (int i = 0; i < 30; i++) {
            x1 = random.nextInt(width);
            x2 = random.nextInt(12);
            y1 = random.nextInt(height);
            y2 = random.nextInt(12);
            g1.drawLine(x1,y1,x1+x2,x2+y2);
        }
        req.getSession().setAttribute("randomCode",word);
        g1.dispose();


        try {
            ImageIO.write(image,"jpg",resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            resp.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if(fc>255){
            fc = 255;
        }
        if(bc>255){
            bc = 255;
        }
        int r = fc+random.nextInt(bc-fc);
        int g = fc+random.nextInt(bc-fc);
        int b = fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
    private List<String> getWords(ServletContext app) {

        List<String> words = new ArrayList<String>();
        BufferedReader reader = null;
        String path = app.getRealPath("/WEB-INF/new_words.txt");
        try {
            InputStreamReader ist = new InputStreamReader(new FileInputStream(path),"UTF-8");
            reader = new BufferedReader(ist);
            String line;

            while ((line = reader.readLine()) != null){
                words.add(line);
            }
        }catch (Exception e){

        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return words;
    }
}
