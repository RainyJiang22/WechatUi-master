package com.example.wechatui_design.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/11/11.
 */

public class Main extends AppCompatActivity {
     private TextView account_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        account_view = (TextView) findViewById(R.id.account_text);
        Intent intent = getIntent();
        String num1 = intent.getStringExtra("account");
        account_view.setText(num1);



    }
}
