package com.example.mychat_master.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mychat_master.DB.Message;
import com.example.mychat_master.DB.ActivityCollector;
import com.example.mychat_master.DB.MessageAdapter;
import com.example.mychat_master.DB.MySQLiteOpenHelper;
import com.example.mychat_master.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacky on 2018/10/21.
 */

public class WeixinFragment extends Fragment {

     private List<com.example.mychat_master.DB.Message> msglist;
     private MessageAdapter adapter;
     private MySQLiteOpenHelper helper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_weixin,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ActivityCollector.add(getActivity());
        helper = new MySQLiteOpenHelper(getActivity(),"ContactMessage.db",null,1);
        //线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = getActivity().findViewById(R.id.rv_messagelist);
        recyclerView.setLayoutManager(layoutManager);
        msglist = new ArrayList<>();
        initData();
        adapter = new MessageAdapter(msglist,getContext());
        //给RecyclerView设置适配器
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        //通过帮助类对象打开一个可读可写的数据库对象
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.query("message",null,null,null,null,null,null);
        while(cursor.moveToNext()){

            int imgHeadId=cursor.getInt(cursor.getColumnIndex("imgHeadId"));
            String friend=cursor.getString(cursor.getColumnIndex("friend"));
            String message=cursor.getString(cursor.getColumnIndex("msg"));
            String time=cursor.getString(cursor.getColumnIndex("time"));
            Message msg=new Message(imgHeadId,friend,message,time);
            msglist.add(msg);
        }
        //关闭数据库
        db.close();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(getActivity());
    }
}
