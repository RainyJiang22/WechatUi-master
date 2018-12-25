package com.example.mychat_master.Util;

import android.graphics.Bitmap;

/**
 * Created by Jacky on 2018/11/18.
 */

public class News {

    private int type;
    private String content;
    private Bitmap icon;


    public News(){
    }

    public News(int type, String content, Bitmap icon) {
        this.type = type;
        this.content = content;
        this.icon = icon;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
}
