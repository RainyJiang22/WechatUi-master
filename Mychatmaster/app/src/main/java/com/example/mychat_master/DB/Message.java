package com.example.mychat_master.DB;

public class Message {

    int img_head;
    String friend;
    String msg;
    String time;

    public Message(int img_head, String friend, String msg, String time) {
        this.img_head = img_head;
        this.friend = friend;
        this.msg = msg;
        this.time = time;
    }

    public void setImg_head(int img_head) {
        this.img_head = img_head;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImg_head() {
        return img_head;
    }

    public String getFriend() {
        return friend;
    }

    public String getMsg() {
        return msg;
    }

    public String getTime() {
        return time;
    }

}
