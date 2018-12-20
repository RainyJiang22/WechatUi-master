package com.example.mychat_master.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mychat_master.Common.Utils;
import com.example.mychat_master.MainActivity;
import com.example.mychat_master.R;


/**
 * Created by Jacky on 2018/10/26.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_title;
    private ImageView img_back;

    private Button btn_login;
    private Button btn_register;
    private Button btn_qtfindpassword;
    private Button btn_help;
    private EditText et_usertel, et_password;

    private CheckBox mermorize_password,auto_login;
    private String userNameValue,passwordValue;
    private SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_login);
        //获取实例对象
        sp = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        initControl();
        initData();
        initView();
        setListener();


        //监听记住密码多选框按钮事件
        mermorize_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mermorize_password.isChecked()){
                    System.out.println("记住密码已选中");
                    sp.edit().putBoolean("ISCHECK",true).commit();
                }else{
                    System.out.println("记住密码未选中");
                    sp.edit().putBoolean("ISCHECK",false).commit();
                }
            }
        });


        //监听自动登录多选框按钮事件
        auto_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (auto_login.isChecked()){
                    System.out.println("自动登录已选中");
                    sp.edit().putBoolean("AUTO_ISCHECK",true).commit();
                }else{
                    System.out.println("自动登录未选中");
                    sp.edit().putBoolean("AUTO_ISCHECK",false).commit();
                }
            }
        });
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

        mermorize_password = (CheckBox) findViewById(R.id.memorize_password);
        auto_login = (CheckBox) findViewById(R.id.auto_login);


       if (sp.getBoolean("ISCHECK",false)){
           //设置默认是记录密码状态
           mermorize_password.setChecked(true);
           et_usertel.setText(sp.getString("USER_NAME",""));
           et_password.setText(sp.getString("PASSWORD",""));
        //   et_password.setText(sp.getString("PASSWORD",""));

           //判断自动登录多选框状态
           if (sp.getBoolean("AUTO_ISCHECK",false))
           {
               //设置默认是自动登录状态
               //跳转页面
               Intent intent = new Intent(LoginActivity.this,MainActivity.class);
               overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
               startActivity(intent);
           }
       }




    }

    protected void initView() {

    }

    protected void initData() {

    }


    /**
     * 设置监听器
     */
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

               //获取输入的Editext值
//               String account = et_usertel.getText().toString();
//               Intent intent = new Intent();
//               intent.putExtra("account",account);
               userNameValue = et_usertel.getText().toString();
               passwordValue = et_password.getText().toString();
               if (userNameValue.equals("user")&& passwordValue.equals("123456")){
                   Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                   if (mermorize_password.isChecked()){
                       //记住用户，密码
                       SharedPreferences.Editor editor = sp.edit();
                       editor.putString("USER_NAME",userNameValue);
                       editor.putString("PSSWORD",passwordValue);
                       editor.commit();
                   }
                   //跳转页面
                   Intent intent =  new Intent();
                   intent.setClass(LoginActivity.this,MainActivity.class);
                   startActivity(intent);
                   overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);

               } else{
                   Toast.makeText(this,"用户或密码错误，请重新登录",Toast.LENGTH_SHORT).show();
               }
               break;
       }
    }


    /**
     * Editext监听器
     */
    class TextChange implements TextWatcher {

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
