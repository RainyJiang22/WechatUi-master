package com.example.wechatui_design.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.wechatui_design.R;

import java.util.List;

/**
 * Created by Jacky on 2018/11/13.
 */


public class TheListAdapter extends BaseAdapter {

    private Context context;
    private List<Message> mList;

    public TheListAdapter(Context context, List<Message> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.wechat_message,null);
      ImageView imageView =  view.findViewById(R.id.icon_photo);
        return null;
    }
}
