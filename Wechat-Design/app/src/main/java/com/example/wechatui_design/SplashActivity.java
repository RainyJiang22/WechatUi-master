package com.example.wechatui_design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.wechatui_design.Activity.LoginActivity;

/**
 * Created by Jacky on 2018/10/12.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_start);
        Integer time = 2000;
        Handler handler = new Handler();
        //当计时结束的时候，跳转到主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                SplashActivity.this.finish();

            }
        },time);

    }
}
