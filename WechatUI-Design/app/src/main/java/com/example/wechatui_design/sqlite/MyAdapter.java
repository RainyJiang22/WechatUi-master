package com.example.wechatui_design.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.wechatui_design.R;

import java.util.List;

/**
 * Created by Jacky on 2018/11/20.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;


    List<Person> personList;



    public MyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return personList.size();
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
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        Person p = personList.get(position);
        ViewHolder viewHolder = null;
        if (convertview == null){
            viewHolder = new ViewHolder();
            convertview =  inflater.inflate(R.layout.wechat_message,null);

            viewHolder.imageId = convertview.findViewById(R.id.icon_image);
            viewHolder.name = convertview.findViewById(R.id.icon_name);
            viewHolder.message = convertview.findViewById(R.id.icon_message);
            viewHolder.date = convertview.findViewById(R.id.icon_date);
            convertview.setTag(viewHolder);
        }
        else{
            viewHolder  = (ViewHolder) convertview.getTag();
        }

        //向TextView中插入数据
        viewHolder.imageId.setImageResource(p.getImageId());
        viewHolder.name.setText(p.getName());
        viewHolder.message.setText(p.getMessage());
        viewHolder.date.setText(p.getDate());

        return convertview;
    }

    class ViewHolder {
        private ImageView imageId;
        private TextView name;
        private TextView message;
        private TextView date;
    }




}
