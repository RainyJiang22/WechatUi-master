package com.example.wechatui_design.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wechatui_design.Common.BaseActivity;
import com.example.wechatui_design.Common.Utils;
import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/10/26.
 */

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener{
    private TextView txt_title;
    private ImageView image_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_register);
         initControl();
        initView();
        initData();
        setListener();
    }



    protected void initControl() {
          txt_title = (TextView) findViewById(R.id.txt_title);
          txt_title.setText("注册");
          image_back = (ImageView) findViewById(R.id.img_back);
          image_back.setVisibility(View.VISIBLE);
    }


    protected void initView() {

    }


    protected void initData() {

    }


    protected void setListener() {
           image_back.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.img_back:
                  Utils.finish(RegisterActivity.this);
                  break;

          }
    }
}
