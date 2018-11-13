package com.example.wechatui_design.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/11/13.
 */

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_listview);
    }


    private void Init(){
        listView = (ListView) findViewById(R.id.wechat_listview);
    }

}
