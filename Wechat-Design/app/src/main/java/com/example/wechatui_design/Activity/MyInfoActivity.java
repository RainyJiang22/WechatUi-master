package com.example.wechatui_design.Activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.wechatui_design.R;

public class MyInfoActivity extends AppCompatActivity {

    private TextView myinfo_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_myinfo);


        myinfo_more = (TextView) findViewById(R.id.tv_temp_more);
        myinfo_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyInfoActivity.this,MyInfoMoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
