package com.example.wechatui_design.sqlite;

/**
 * Created by Jacky on 2018/11/20.
 */

public class Person {

    public String _id;
    public int imageId;
    public String name;
    public String message;
    public String date;

    public Person(String _id, int imageId, String name, String message, String date) {
        this._id = _id;
        this.imageId = imageId;
        this.name = name;
        this.message = message;
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return name + "," + message + "," + date;
    }
}
