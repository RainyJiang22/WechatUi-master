package com.example.wechatui_design.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wechatui_design.Common.BaseActivity;
import com.example.wechatui_design.Common.Utils;
import com.example.wechatui_design.MainActivity;
import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/10/26.
 */

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView txt_title;
    private ImageView img_back;

    private Button btn_login;
    private Button btn_register;
    private Button btn_qtfindpassword;
    private Button btn_help;
    private EditText et_usertel, et_password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_login);
        initControl();
        initData();
        initView();
        setListener();
    }


    /**
     * 绑定控件id
     */

    protected void initControl() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setText("登录");
        //显示图标
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_qtlogin);
        btn_help = (Button) findViewById(R.id.btn_more);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_password = (EditText) findViewById(R.id.et_password);
    }

    protected void initView() {

    }

    protected void initData() {

    }


    protected void setListener() {
        img_back.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_help.setOnClickListener(this);
        et_usertel.addTextChangedListener(new TextChange());
        et_password.addTextChangedListener(new TextChange());
    }


    /**
     * 设置点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.img_back:
               Utils.finish(LoginActivity.this);
               break;
           case R.id.btn_qtlogin:
               startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
               overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
               break;
           case R.id.btn_more:
               break;
           case R.id.btn_login:
               startActivity(new Intent(LoginActivity.this, MainActivity.class));
               overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
               Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
               break;
       }
    }


    /**
     * Editext监听器
     */
    class TextChange implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                  boolean Sign1 = et_usertel.getText().length() > 0;
                  boolean Sign2 = et_password.getText().length() > 4;

            if (Sign1 & Sign2){
                btn_login.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_bg_green));
                btn_login.setEnabled(true);
            }
            else{
                btn_login.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_enable_green));
                btn_login.setTextColor(0xFFD0EFC6);
                btn_login.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

}
