package com.example.mychat_master.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.mychat_master.DB.ActivityCollector;
import com.example.mychat_master.R;

public class SettingActivity extends AppCompatActivity {

   private RelativeLayout re_logout;
   private RelativeLayout re_outline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_setting);


        //强制下线
        re_outline = findViewById(R.id.re_outwechat);
        re_outline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送广播
                Intent intent = new Intent("com.example.mychat_master.FORCELINE");
                sendBroadcast(intent);
                //之前测试用
//                new AlertDialog.Builder(SettingActivity.this).setTitle("下线通知")
//                        .setMessage("您有另外一台移动设备登录了此账号，需要下线").setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        ActivityCollector.finishAll();
//                        Intent intent_login=new Intent(SettingActivity.this, LoginActivity.class);
//                        startActivity(intent_login);
//                    }
//                }).show();

            }
        });

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
