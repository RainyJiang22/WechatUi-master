package com.example.wechatui_design.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/10/16.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonpanel;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        /**
         * 接收firstactivity传递过来的数据
         */
        textView = (TextView) findViewById(R.id.inuput_textview);
        Intent intent = getIntent();
        String data = intent.getStringExtra("input_data");
        textView.setText(data);


        /**
         * 添加返回数据的逻辑
         */
        buttonpanel = (Button) findViewById(R.id.buttonPanel);
        buttonpanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent1 = new Intent();
                intent1.putExtra("return_data","Hello the first page");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });

    }
}
