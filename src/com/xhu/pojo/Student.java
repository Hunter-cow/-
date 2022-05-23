package com.xhu.pojo;

public class Student {
    private Integer id;
    private String Name;
    private String username;
    private String Password;
    private String Code;
    private int Sex;
    private int Age;
    private int gid;
    private String Jineng;
    private String zhiyuan;
    private String chuqing;
    private String Score;

    public Student() {
    }

    public Student(String name, int gid) {
        Name = name;
        this.gid = gid;
    }

    public Student(String name, int sex, int gid) {
        Name = name;
        Sex = sex;
        this.gid = gid;
    }

    public Student(String username, String password) {
        this.username = username;
        Password = password;
    }

    public Student(Integer id,String name, String username, String code, int sex, int age, int gid, String jineng, String zhiyuan, String chuqing, String score) {
        this.id = id;
        Name = name;
        this.username = username;
        Code = code;
        Sex = sex;
        Age = age;
        this.gid = gid;
        Jineng = jineng;
        this.zhiyuan = zhiyuan;
        this.chuqing = chuqing;
        Score = score;
    }

    public Student(Integer id, String name, String username, String password, String code, int sex, int age, int gid, String jineng, String zhiyuan, String chuqing, String score) {
        this.id = id;
        Name = name;
        this.username = username;
        Password = password;
        Code = code;
        Sex = sex;
        Age = age;
        this.gid = gid;
        Jineng = jineng;
        this.zhiyuan = zhiyuan;
        this.chuqing = chuqing;
        Score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getJineng() {
        return Jineng;
    }

    public void setJineng(String jineng) {
        Jineng = jineng;
    }

    public String getZhiyuan() {
        return zhiyuan;
    }

    public void setZhiyuan(String zhiyuan) {
        this.zhiyuan = zhiyuan;
    }

    public String getChuqing() {
        return chuqing;
    }

    public void setChuqing(String chuqing) {
        this.chuqing = chuqing;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", username='" + username + '\'' +
                ", Password='" + Password + '\'' +
                ", Code='" + Code + '\'' +
                ", Sex=" + Sex +
                ", Age=" + Age +
                ", gid=" + gid +
                ", Jineng='" + Jineng + '\'' +
                ", zhiyuan='" + zhiyuan + '\'' +
                ", chuqing='" + chuqing + '\'' +
                ", Score='" + Score + '\'' +
                '}';
    }
}
