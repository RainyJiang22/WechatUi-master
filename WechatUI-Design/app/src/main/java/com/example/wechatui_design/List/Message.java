package com.example.wechatui_design.List;

import android.widget.ImageView;

/**
 * Created by Jacky on 2018/11/13.
 */

public class Message {

    private int ImageId;
    private String name;
    private String messeng;
    private String date;

    public Message(int imageId, String name, String messeng, String date) {
        ImageId = imageId;
        this.name = name;
        this.messeng = messeng;
        this.date = date;
    }

    public int getImageId() {
        return ImageId;
    }

    public String getName() {
        return name;
    }

    public String getMesseng() {
        return messeng;
    }
    public String getDate() {
        return date;
    }

}
