package com.example.mychat_master.Common;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.mychat_master.R;

public class AddPopWindow extends PopupWindow {

    private View contentView;


    public AddPopWindow(final Activity context){


        //对于没有继承相关Activity的java文件,可以使用Layoutflater，可以使用LayoutFlater找相关布局文件

        /**
         * 另外getSystemService()是Android很重要的一个API，它是Activity的一个方法，
         * 根据传入的NAME来取得对应的Object，然后转换成相应的服务对象。
         * 以下介绍系统相应的服务。
         */
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //取得自定义的view
         contentView = inflater.inflate(R.layout.itempopup_add,null);


         //设置SelectPopupWindow的视图
         this.setContentView(contentView);

         //设置SelectPopupWindow弹出窗体的高度
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        //设置SelectPopupWindow弹出窗体的宽度
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);

        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);

        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);


        RelativeLayout re_addfriends = contentView.findViewById(R.id.re_addfriends);
        RelativeLayout re_chatroomm = contentView.findViewById(R.id.re_chatroom);
        RelativeLayout re_shaoshao = contentView.findViewById(R.id.re_saoyisao);



        //点击添加朋友
        re_addfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        //点击添加群聊
        re_chatroomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //点击扫一扫
        re_shaoshao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, 0, 0);
        } else {
            this.dismiss();
        }
    }
}
