package com.example.wechatui_design.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/11/15.
 */

public class SqliteActivity extends AppCompatActivity {

    private MySqliteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_createdatabase);
        helper = DbManager.getIntance(this);
    }


    /**
     * 创建数据库
     * @param view
     */
    public void createDb(View view){

        /**
         * 创建打开这个数据库，
         * 如果不存在就创建，存在就直接打开数据库
         * 默认情况下两个函数都表示创建可读或者可写的情况
         */
        SQLiteDatabase db = helper.getWritableDatabase();
    }
}
