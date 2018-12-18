package com.example.wechatui_design.sqlite;

import android.content.Context;

/**
 * Created by Jacky on 2018/11/15.
 * 主要是对数据库操作的工具类
 */

public class DbManager {

    public static MySqliteHelper helper;
    public static MySqliteHelper getIntance(Context context){
        if (helper == null){
            helper = new MySqliteHelper(context);
        }
        return helper;
    }
}
