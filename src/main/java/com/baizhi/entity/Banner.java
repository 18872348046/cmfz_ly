package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private String id;
    private String title;
    private String imgPoth;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String status;
    private String descs;

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPoth='" + imgPoth + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", descs='" + descs + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPoth() {
        return imgPoth;
    }

    public void setImgPoth(String imgPoth) {
        this.imgPoth = imgPoth;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Banner(String id, String title, String imgPoth, Date date, String status, String descs) {
        this.id = id;
        this.title = title;
        this.imgPoth = imgPoth;
        this.date = date;
        this.status = status;
        this.descs = descs;
    }

    public Banner() {
    }
}
