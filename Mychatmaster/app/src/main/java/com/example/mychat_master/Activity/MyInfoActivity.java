package com.example.mychat_master.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mychat_master.R;


public class MyInfoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_myinfo);


      RelativeLayout myinfo_more =  findViewById(R.id.re_temp_more);
        myinfo_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MyInfoActivity.this,MyInfoMoreActivity.class));
            }
        });
    }
}
