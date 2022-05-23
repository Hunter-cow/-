package com.xhu.pojo;

public class Grade {
    private Integer id;
    private String Name;
    private String Code;
    private String Remark;

    public Grade() {
    }

    public Grade(Integer id, String name, String code, String remark) {
        this.id = id;
        Name = name;
        Code = code;
        Remark = remark;
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

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
