package com.example.wechatui_design.Chat.widght;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Jacky on 2018/11/23.
 */

public class PasteEditText extends android.support.v7.widget.AppCompatEditText {
    private Context context;



    public PasteEditText(Context context) {
        super(context);
       this.context = context;
    }

    public PasteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        // TODO Auto-generated constructor stub
    }



}
