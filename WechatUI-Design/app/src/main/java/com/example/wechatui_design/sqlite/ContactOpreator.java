package com.example.wechatui_design.sqlite;

/**
 * Created by Jacky on 2018/11/16.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wechatui_design.Bean.ContactBean;


public class ContactOpreator {
    private MySqliteHelper dbHelper;
    private SQLiteDatabase db;

    public ContactOpreator(Context context) {
        dbHelper = new MySqliteHelper(context, "lxrData", null, 1);
        db = dbHelper.getWritableDatabase();
    }

    // 添加联系人
    public void add(ContactBean lxr) {
        db.execSQL("insert into lxrData values(?,?,?)",
                new Object[] { lxr.getName(), lxr.getMessage(), lxr.getDate() });

    }

    // 修改联系人
    public void update(ContactBean lxr) {
        db.execSQL("update lxrData set message=?,date=? where name=?",
                new Object[] { lxr.getMessage(), lxr.getDate(), lxr.getName() });
    }

    // 删除联系人
    public void delete(String name) {
        db.execSQL("delete from lxrData where name=?", new String[] { name });
    }

    // 查询联系人
    public ContactBean queryOne(String name) {
        ContactBean lxr = new ContactBean();
        Cursor c = db.rawQuery("select * from lxrData where name= ?", new String[] { name });
        while (c.moveToNext()) {
            lxr.setName(c.getString(0));
            lxr.setMessage(c.getString(1));
            lxr.setDate(c.getString(2));
        }
        c.close();
        return lxr;
    }

    public List<ContactBean> queryAlllxr() {
        ArrayList<ContactBean> lxrs = new ArrayList<ContactBean>();
        Cursor c = db.rawQuery("select name from lxrData", null);
        while (c.moveToNext()) {
            ContactBean lxr = new ContactBean();
            lxr.setName(c.getString(0));
            lxrs.add(lxr);
        }
        c.close();
        return lxrs;

    }

    // 查询所有的联系人信息
    public List<ContactBean> queryMany() {
        ArrayList<ContactBean> lxrs = new ArrayList<ContactBean>();
        Cursor c = db.rawQuery("select * from lxrData", null);
        while (c.moveToNext()) {
            ContactBean lxr = new ContactBean();
            lxr.setName(c.getString(0));
            lxr.setMessage(c.getString(1));
            lxr.setDate(c.getString(2));
            lxrs.add(lxr);
        }
        c.close();
        return lxrs;
    }

    // 检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from lxrData where name =?";
        Cursor cursor = db.rawQuery(Query, new String[] { value });
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    // 判断信息是否已经存在
    public boolean Dataexist(String name, String message, String date) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from lxrData where name =? and message=? and date=?";
        Cursor cursor = db.rawQuery(Query, new String[] { name, message, date });
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

}

