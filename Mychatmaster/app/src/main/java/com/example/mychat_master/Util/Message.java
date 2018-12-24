package com.example.mychat_master.Util;

public class Message {

    private int image_head;
    private String friend;
    private String message;
    private String time;

    public Message(int image_head, String friend, String message, String time) {
        this.image_head = image_head;
        this.friend = friend;
        this.message = message;
        this.time = time;
    }

    public int getImage_head() {
        return image_head;
    }

    public void setImage_head(int image_head) {
        this.image_head = image_head;
    }


    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
