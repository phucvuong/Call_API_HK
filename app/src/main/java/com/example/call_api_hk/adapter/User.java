package com.example.call_api_hk.adapter;

public class User{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int id;
    private String title;

    public User(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
