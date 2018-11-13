package com.example.wechatui_design.Adapter;

/**
 * Created by Jacky on 2018/11/13.
 */

public class FriendMode {
    private String f_name;
    private  String f_introduce;
    private  char f_sex;
    private  int f_iv;

    public FriendMode(String f_name, String f_introduce, char f_sex, int f_iv) {
        this.f_name = f_name;
        this.f_introduce = f_introduce;
        this.f_sex = f_sex;
        this.f_iv = f_iv;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_introduce() {
        return f_introduce;
    }

    public void setF_introduce(String f_introduce) {
        this.f_introduce = f_introduce;
    }

    public char getF_sex() {
        return f_sex;
    }

    public void setF_sex(char f_sex) {
        this.f_sex = f_sex;
    }

    public int getF_iv() {
        return f_iv;
    }

    public void setF_iv(int f_iv) {
        this.f_iv = f_iv;
    }
}
