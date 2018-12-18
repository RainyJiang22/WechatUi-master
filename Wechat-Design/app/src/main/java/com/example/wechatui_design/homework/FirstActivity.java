package com.example.wechatui_design.homework;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/10/16.
 */

public class FirstActivity extends AppCompatActivity {

    //定义Button吐司按钮
    private Button toast;

    //定义显示跳转按钮
    private Button page_jump;

    //定义隐式跳转按钮
    private Button page_jump2;

    //定义拨号跳转按钮
    private Button phone;


    //定义浏览器按钮
    private Button browser;

    //定义传递数据按钮
    private Button inputdata;
    private Button returndata;


    //定义发信息按钮
    private Button setmessage;
    //定义地图按钮
    private Button map;
    //定义email按钮
    private Button contactlist;
    //定义多媒体按钮
    private Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        /**
         * 吐司提示
         */

        toast = (Button) findViewById(R.id.Toast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"这是一个小提示",Toast.LENGTH_LONG).show();
            }
        });


        /**
         * 显示跳转到SecondActivity
         */
        page_jump = (Button) findViewById(R.id.page_jump);
        page_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


        /**
         * 隐式跳转到SecondActivity
         */
        page_jump2 = (Button) findViewById(R.id.page_jump2);
        page_jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.wechatui_design.homework.ACTION_START");
                startActivity(intent);
        }
        });

        /**
         * 隐式跳转到拨号界面
         */
        phone = (Button) findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });


        /**
         * 隐式跳转到浏览器界面
         */
        browser = (Button) findViewById(R.id.browser);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        /**
         * 传递数据给下一个活动
         */
        inputdata = (Button) findViewById(R.id.input_data);
        inputdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "Hello this world";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("input_data",data);
                startActivity(intent);
            }
        });


        /**
         * 返回数据给上一个活动
         */
        returndata = (Button) findViewById(R.id.return_data);
        returndata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });


        /**
         *发送短信
         */
        setmessage = (Button) findViewById(R.id.set_message);
        setmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:13410177756");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "TheSMS text");
                startActivity(it);
            }
        });

        /**
         *调用搜索
         */
        contactlist = (Button) findViewById(R.id.set_Contactlist);
        contactlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"android123");
                startActivity(intent);

            }
        });


        /**
         *调用电子邮件
         */
        video = (Button) findViewById(R.id.set_video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent();
                intent5.setAction(Intent.ACTION_SEND);
                intent5.putExtra(Intent.EXTRA_SUBJECT,"邮件主题");
                intent5.putExtra(Intent.EXTRA_EMAIL,"1050543797@qq.com");
                intent5.putExtra(Intent.EXTRA_TEXT,"hello");
                intent5.setType("text/plain");
                startActivity(intent5);
            }
        });


        /**
         * 显示地图
         */
        map = (Button) findViewById(R.id.set_map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:38.899533,-77.036476");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returndata = data.getStringExtra("return_data");
                    Log.d("FirstActivity",returndata);
                }
                break;
             default:
        }
    }
}
