package com.example.mychat_master.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mychat_master.R;

/**
 * Created by Administrator on 2018/6/1.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    //参数context:上下文环境
    //参数name:数据库名称
    //参数factory：游标工厂,一般填null
    //参数version：数据库版本
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //数据库被创建的时候调用:定义数据库所需要的表
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表message
        db.execSQL("create table message (" +
                "id integer primary key autoincrement," +
                "imgHeadId integer,"+
                "friend varchar(10)," +
                "msg varchar(50)," +
                "time varchar(10))");

        ContentValues cv=new ContentValues();
        //cv.put(字段名，字段值)
        //cv可以理解为表中一条记录对应的Java对象

            cv.put("imgHeadId", R.drawable.image1);
            cv.put("friend", "老爸");
            cv.put("msg", "最近过的还好吗？");
            cv.put("time", "13:12");
            db.insert("message", null, cv);
            cv.put("imgHeadId", R.drawable.image2);
            cv.put("friend", "老妈");
            cv.put("msg", "钱还够吗？");
            cv.put("time", "周三");
            db.insert("message", null, cv);
            cv.put("imgHeadId", R.drawable.image3);
            cv.put("friend", "林杰");
            cv.put("msg", "有空一起出来聚聚呗");
            cv.put("time", "周一");
            db.insert("message", null, cv);
            cv.put("imgHeadId", R.drawable.image4);
            cv.put("friend", "张凡");
            cv.put("msg", "这道题莫名其妙");
            cv.put("time", "周日");
            db.insert("message", null, cv);
        }

    //数据库更新的时候调用
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
