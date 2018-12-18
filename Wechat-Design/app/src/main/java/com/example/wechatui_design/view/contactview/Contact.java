package com.example.wechatui_design.view.contactview;

import java.io.Serializable;

public class Contact implements Serializable {

    private String mName;
    private int mType;

    public Contact(String mName, int mType) {
        this.mName = mName;
        this.mType = mType;
    }

    public String getmName() {
        return mName;
    }

    public int getmType() {
        return mType;
    }
}
