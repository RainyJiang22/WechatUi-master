package com.example.wechatui_design.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.List;

/**
 * Created by Jacky on 2018/11/13.
 */

public class FriendAdapter extends BaseAdapter {
    private Context context;
    private int myitemid;
    private List<FriendMode> myData;

    public FriendAdapter(Context context, int myitemid, List<FriendMode> myData) {
        this.context = context;
        this.myitemid = myitemid;
        this.myData = myData;
    }

    @Override
    public int getCount() {
        return myData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View myView= View.inflate(context,myitemid,null);
        return null;
    }
}
