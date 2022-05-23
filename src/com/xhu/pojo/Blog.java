package com.xhu.pojo;

public class Blog {
    private Integer id;
    private String Title;
    private String Content;
    private String Createdate;
    private Integer sid;

    public Blog() {
    }

    public Blog(String title, String content, Integer sid) {
        Title = title;
        Content = content;
        this.sid = sid;
    }

    public Blog(Integer id, String title, String content, String createdate, Integer sid) {
        this.id = id;
        Title = title;
        Content = content;
        Createdate = createdate;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(String createdate) {
        Createdate = createdate;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                ", Createdate='" + Createdate + '\'' +
                ", sid=" + sid +
                '}';
    }
}
