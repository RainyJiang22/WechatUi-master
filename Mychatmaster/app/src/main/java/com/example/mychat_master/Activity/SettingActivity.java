package com.example.mychat_master.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.mychat_master.R;

public class SettingActivity extends AppCompatActivity {

   private RelativeLayout re_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_setting);

        re_logout = findViewById(R.id.re_logout);
       re_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               logout();
            }

           private void logout() {

             final ProgressDialog pd = new ProgressDialog(SettingActivity.this);
               pd.setMessage("正在退出登陆..");
               pd.setCanceledOnTouchOutside(false);
               pd.show();
               Integer time = 2000;
               //当计时结束的时候，退出应用
               Handler handler = new Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       pd.dismiss();
                       // 重新显示登陆页面
                       finish();
                       startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                   }
               },time);
           }
       });
    }


}
