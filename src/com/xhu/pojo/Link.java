package com.xhu.pojo;

public class Link {
    private Integer id;
    private String Name;
    private String Link;

    public Link() {
    }

    public Link(Integer id, String name, String link) {
        this.id = id;
        Name = name;
        Link = link;
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

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
