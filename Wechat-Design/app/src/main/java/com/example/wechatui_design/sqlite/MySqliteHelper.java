package com.example.wechatui_design.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jacky on 2018/11/15.
 * 1.提供了获取数据库对象的函数
 */

public class MySqliteHelper extends SQLiteOpenHelper {
    /**
     *
     * @param context 上下文  Context
     * @param name   表示创建数据库的名称
     * @param factory   表示数据库的游标工厂
     * @param version   表示数据库的版本
     */



    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public MySqliteHelper(Context context){
        super(context,Constant.DATABASE_NAME,null,Constant.DATABASE_VERSION);
    }

    /**
     * 当数据库创建的时候进行回调的函数
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_USERDATA = "create table "+Constant.TABLE_NAME+"(_id Integer,imageId BLOB, name varchar(200) primary key, message varchar(200),date varchar(200))";
        sqLiteDatabase.execSQL(CREATE_USERDATA);
    }

    /**
     * 当数据库版本更新的时候回调的对象
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 当数据库打开的时候进行回调的函数
     * @param db
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
