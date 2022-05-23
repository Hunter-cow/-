package com.xhu.pojo;

public class User {
    private Integer id;
    private String username;
    private String Password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        Password = password;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.Password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.Password = password;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", username='" + username + '\'' +
                ", Password='" + Password ;
    }
}
