package com.xhu.pojo;


public class Note {
    private Integer id;
    private String Title;
    private String Content;
    private String Createdate;

    public Note() {
    }

    public Note(Integer id, String title, String content, String Createdate) {
        this.id = id;
        Title = title;
        Content = content;
        this.Createdate = Createdate;
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

    public void setCreatedate(String Createdate) {
        this.Createdate = Createdate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Content='" + Content + '\'' +
                ", datetime='" + Createdate+ '\'' +
                '}';
    }
}
