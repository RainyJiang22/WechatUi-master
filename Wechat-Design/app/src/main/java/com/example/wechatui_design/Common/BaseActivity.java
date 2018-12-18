package com.example.wechatui_design.Common;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by Jacky on 2018/10/30.
 */

public abstract class BaseActivity extends AppCompatActivity {

    //获取Activity上下文
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initControl();
        initView();
        initData();
        setListener();

    }





    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Utils.finish(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 绑定控件id
     */
    protected abstract void initControl();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置监听
     */
    protected abstract void setListener();

}
