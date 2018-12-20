package com.example.mychat_master.Common;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;


import com.example.mychat_master.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jacky on 2018/10/30.
 */

public class Utils {

    //设置长时间Toast
    public static void showLongToast(Context context, String pMsg) {
        Toast.makeText(context, pMsg, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(Context context, String pMsg) {
        Toast.makeText(context, pMsg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 关闭Activity
     */
    public static void  finish(Activity activity){
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }



    /**
     * 验证手机号
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(17[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 验证邮箱
     */
    public static boolean isEmail(String email){
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 验证数字（验证验证码）
     */
    public static boolean isNumber(String str){
        Pattern p =  Pattern.compile("[0-9]*");
        java.util.regex.Matcher matcher = p.matcher(str);
        if (matcher.matches() == false){
            return false;
        }
        else{
            return true;
        }
    }

}
