package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String imgPath;
    private String content;
    private String status;
    private String classift;
    private Gurn gurn;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", classift='" + classift + '\'' +
                ", gurn=" + gurn +
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassift() {
        return classift;
    }

    public void setClassift(String classift) {
        this.classift = classift;
    }

    public Gurn getGurn() {
        return gurn;
    }

    public void setGurn(Gurn gurn) {
        this.gurn = gurn;
    }

    public Article() {
    }

    public Article(String id, String title, Date date, String imgPath, String content, String status, String classift, Gurn gurn) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.imgPath = imgPath;
        this.content = content;
        this.status = status;
        this.classift = classift;
        this.gurn = gurn;
    }
}
