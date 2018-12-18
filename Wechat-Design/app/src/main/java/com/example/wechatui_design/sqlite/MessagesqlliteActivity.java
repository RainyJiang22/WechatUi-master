package com.example.wechatui_design.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wechatui_design.Activity.ChatActivity;
import com.example.wechatui_design.List.Message;
import com.example.wechatui_design.List.MessageListActivity;
import com.example.wechatui_design.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacky on 2018/11/20.
 */

public class MessagesqlliteActivity extends AppCompatActivity {


    List<Person> personList;
    MySqliteHelper sqliteHelper;
    SQLiteDatabase db;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_listview);
        ListView lv = (ListView) findViewById(R.id.wechat_listview);
        personList = new ArrayList<Person>();
        //创建实例
        sqliteHelper = new MySqliteHelper(this);
        //得到数据库
        db  = sqliteHelper.getWritableDatabase();
        //插入数据
         insertData();
        //查询在界面上显示数据


        myAdapter = new MyAdapter(this);
        //向listview中添加Adapter
        lv.setAdapter(myAdapter);



        /**
         * 设置listview点击事件
         */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Person p = personList.get(position);

                switch (adapterView.getId()){
                    case R.id.wechat_listview:
                        Intent intent = new Intent(MessagesqlliteActivity.this,ChatActivity.class);
                        intent.putExtra("name",p.getName());
                        intent.putExtra("message",p.getMessage());
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }

            }
        });
        db.close();
    }


    //插入数据
    private void insertData() {
        for(int i =0;i<4;i++){
            ContentValues values = new ContentValues();
            if (i == 0){
                values.put("name","老爸");
                values.put("message","最近过的还好吗？");
                values.put("date","13:12");
                db.insert(Constant.TABLE_NAME,null,values);
            } else if(i == 1){
                values.put("name","老妈");
                values.put("message","钱还够吗？");
                values.put("date","周三");
                db.insert(Constant.TABLE_NAME,null,values);
            } else if (i == 2){
                values.put("name","林杰");
                values.put("message","有空一起出来聚聚呗");
                values.put("date","周一");
                db.insert(Constant.TABLE_NAME,null,values);
            } else{
                values.put("name","张凡");
                values.put("message","这道题莫名其妙");
                values.put("date","周日");
                db.insert(Constant.TABLE_NAME,null,values);
            }
        }

    }


    // 查询数据
    public void Query() {
        //游标
        Cursor cursor = db.query(Constant.TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            String _id = cursor.getString(0);
            int imageId = cursor.getInt(1);
            String name = cursor.getString(1);
            String message = cursor.getString(2);
            String date = cursor.getString(3);
            Person person = new Person(_id,imageId, name, message, date);
            personList.add(person);
        }
    }


    //存储图片，图片转化为二进制数据

    public byte[] bitmabToBytes(Context context, View position){

        //将图片转化为位图
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.image3);
        int size = bitmap.getWidth() * bitmap.getHeight() * 4;
        //创建一个字节数组输出流,流的大小为size
        ByteArrayOutputStream baos= new ByteArrayOutputStream(size);
        try {
            //设置位图的压缩格式，质量为100%，并放入字节数组输出流中
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            //将字节数组输出流转化为字节数组byte[]
            byte[] imagedata = baos.toByteArray();
            return imagedata;
        }catch (Exception e){
        }finally {
            try {
                bitmap.recycle();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new byte[0];

    }




}
