package com.example.mychat_master.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.mychat_master.DB.ActivityCollector;


public class BaseActivity extends AppCompatActivity {

    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //注册广播
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.mychat_master.FORCELINE");


        registerReceiver(receiver,intentFilter);
    }
    class Receiver extends BroadcastReceiver{

        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder dialog=new AlertDialog.Builder(context);
            dialog.setTitle("下线通知");
            dialog.setMessage("您有另外一台移动设备登录了此账号，需要下线");
            dialog.setCancelable(false);
            dialog.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCollector.finishAll();
                    Intent intent_login=new Intent(context, LoginActivity.class);
                    startActivity(intent_login);
                }
            });
            dialog.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
