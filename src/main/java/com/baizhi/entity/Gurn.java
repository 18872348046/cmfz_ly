package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Gurn {
    private String id;
    private String name;
    private String law_name;
    private String headPic;
    private String state;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String sex;

    @Override
    public String toString() {
        return "Gurn{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", law_name='" + law_name + '\'' +
                ", headPic='" + headPic + '\'' +
                ", state='" + state + '\'' +
                ", date=" + date +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLaw_name() {
        return law_name;
    }

    public void setLaw_name(String law_name) {
        this.law_name = law_name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Gurn(String id, String name, String law_name, String headPic, String state, Date date, String sex) {
        this.id = id;
        this.name = name;
        this.law_name = law_name;
        this.headPic = headPic;
        this.state = state;
        this.date = date;
        this.sex = sex;
    }

    public Gurn() {
    }
}
