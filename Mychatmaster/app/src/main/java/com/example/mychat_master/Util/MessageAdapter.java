package com.example.mychat_master.Util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MessageAdapter {

    private List<Message> messageList;
    private Context context;

    /**
     * 1.Adapter需要List作为它的唯一关键属性
     * 在实例化Adapter时传入List具体数据
     */
    public MessageAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    /**
     * 2.定义ViewHolder(视图容器)
     * 里面装的是条目中的所有控件
     * 条目中
     */
}
