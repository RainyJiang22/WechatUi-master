package com.example.wechatui_design.Adapter;

import android.widget.ImageView;

/**
 * Created by Jacky on 2018/11/15.
 * 对象类
 */

public class ItemImage {

    private String name;
    private int imageId;

    public ItemImage(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
