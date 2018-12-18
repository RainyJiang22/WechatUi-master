package com.example.wechatui_design.Bean;

/**
 * Created by Jacky on 2018/11/16.
 */

public class ContactBean {

    private String name;
    private String message;
    private String date;


    public ContactBean(String name, String message, String date) {
        this.name = name;
        this.message = message;
        this.date = date;
    }

    public ContactBean(){
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
