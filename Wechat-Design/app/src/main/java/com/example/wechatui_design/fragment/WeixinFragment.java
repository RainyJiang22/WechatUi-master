package com.example.wechatui_design.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wechatui_design.List.Message;
import com.example.wechatui_design.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacky on 2018/10/21.
 */

public class WeixinFragment extends Fragment {

     private ListView lv;


    private TextView txt_left;
     //集合
     private List<Message> messagetlist=new ArrayList<Message>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weixin,container,false);


    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
