package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
    private String id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date foundDate;
    private String flag;
    private List<Counter> counter=new ArrayList<Counter>();

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", foundDate=" + foundDate +
                ", flag='" + flag + '\'' +
                ", counter=" + counter +
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

    public Date getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Date foundDate) {
        this.foundDate = foundDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<Counter> getCounter() {
        return counter;
    }

    public void setCounter(List<Counter> counter) {
        this.counter = counter;
    }

    public Course(String id, String title, Date foundDate, String flag, List<Counter> counter) {
        this.id = id;
        this.title = title;
        this.foundDate = foundDate;
        this.flag = flag;
        this.counter = counter;
    }

    public Course() {
    }
}
