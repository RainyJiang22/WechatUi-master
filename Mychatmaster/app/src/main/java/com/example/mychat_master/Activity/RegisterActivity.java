package com.example.mychat_master.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
   private Activity context;

    private TextView txt_title;
    private ImageView image_back;

    private Button btn_register,btn_send;
    private EditText et_usertel,et_passsword;
    private EditText et_code;

    private MyCount mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_register);
         initControl();
        initView();
        initData();
        setListener();

      //  initUserList();
    }



    protected void initControl() {
          txt_title = (TextView) findViewById(R.id.txt_title);
          txt_title.setText("注册");
          image_back = (ImageView) findViewById(R.id.img_back);
          image_back.setVisibility(View.VISIBLE);
         btn_send = (Button) findViewById(R.id.btn_send);
        btn_register = (Button) findViewById(R.id.btn_register);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_passsword = (EditText) findViewById(R.id.et_password);
        et_code = (EditText) findViewById(R.id.et_code);
    }


    protected void initView() {

    }


    protected void initData() {

    }


    protected void setListener() {
           image_back.setOnClickListener(this);

            btn_send.setOnClickListener(this);

            btn_register.setOnClickListener(this);
           et_usertel.addTextChangedListener(new TelTextChange());
           et_passsword.addTextChangedListener(new TextChange());
    }


    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.img_back:
                  Utils.finish(RegisterActivity.this);
                  break;
              case R.id.btn_send:
                   if (mc == null) {
                       mc = new MyCount(60000, 1000); //第一个参数是总的时间，第二个参数是间隔时间
                   }
                       break;

              case R.id.btn_register:
                  startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                  overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
                  Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                  break;
              default:
                  break;
          }
    }






    //手机号注册验证EditText监听器
    class  TelTextChange implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                            String phone = et_usertel.getText().toString();
               if (phone.length() == 11) {
                   //判断是否是手机号
                   if (Utils.isMobileNO(phone)) {
                       btn_send.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_bg_green));
                       btn_send.setTextColor(0xFFFFFFFF);
                       btn_send.setEnabled(true);

                       btn_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_bg_green));
                       btn_register.setTextColor(0xFFFFFFFF);
                       btn_register.setEnabled(true);

                   } else {
                       et_usertel.requestFocus();
                       Utils.showLongToast(context, "请输入正确的手机号码");
                   }
               }  else{
                   btn_send.setBackgroundDrawable(getResources().getDrawable(
                           R.drawable.btn_enable_green));
                   btn_send.setTextColor(0xFFD0EFC6);
                   btn_send.setEnabled(false);
                   btn_register.setBackgroundDrawable(getResources().getDrawable(
                           R.drawable.btn_enable_green));
                   btn_register.setTextColor(0xFFD0EFC6);
                   btn_register.setEnabled(true);
               }
        }
        @Override
        public void afterTextChanged(Editable editable) {
        }
    }


    //EditText监听器
    class TextChange implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

             boolean Sign1 = et_usertel.getText().toString().length() > 0;
             boolean Sign2 = et_passsword.getText().toString().length() > 0;
             boolean Sign3 = et_code.getText().toString().length() > 0;

            if (Sign1 & Sign2 & Sign3){

                btn_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_bg_green));
                btn_register.setTextColor(0xFFFFFFFF);
                btn_register.setEnabled(true);
            }
            else{
                btn_register.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_enable_green));
                btn_register.setTextColor(0xFFD0EFC6);
                btn_register.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }


    /**
     * 定义一个倒计时的内部类
     */
    private class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            btn_send.setEnabled(false);
            btn_send.setText("("+l/1000 + ")秒");
        }

        @Override
        public void onFinish() {
            btn_send.setEnabled(true);
            btn_send.setText("发送验证码");
        }

    }

    private void initUserList(){
        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
        finish();
    }
}
