package com.example.user.tm.models;

public class Task {
    private String title;
    private String desc;
    private String date;

    public Task(String title, String desc, String date) {
        this.title = title;
        this.desc = desc;
        this.date = date;
    }



    public Task() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

