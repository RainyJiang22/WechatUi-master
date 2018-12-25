package com.example.mychat_master.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mychat_master.R;

import java.util.ArrayList;

/**
 * Created by Jacky on 2018/11/18.
 */

public class NewsAdapter extends BaseAdapter {

    private ArrayList<News> newsArrayList;
    private LayoutInflater inflater;


    public NewsAdapter(ArrayList<News> newsArrayList, Context context) {
        this.newsArrayList = newsArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        News news = newsArrayList.get(position);
        return news.getType();
    }

    @Override
    public int getViewTypeCount() {
            return 2;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        View view;
        ViewHolder viewHolder;

        if (convertview == null){
            if (getItemViewType(position) == 0){
                view  = inflater.inflate(R.layout.recived_message,null);
                viewHolder = new ViewHolder();
                viewHolder.icon =  view.findViewById(R.id.iconLeft);
                viewHolder.text = view.findViewById(R.id.textLeft);
            }
            else{
                view = inflater.inflate(R.layout.send_message,null);
                viewHolder = new ViewHolder();
                viewHolder.icon = view.findViewById(R.id.iconRight);
                viewHolder.text = view.findViewById(R.id.textRight);

            }
            view.setTag(viewHolder);

        }
        else{
            view = convertview;
            viewHolder = (ViewHolder) view.getTag();

            viewHolder.icon.setImageBitmap(newsArrayList.get(position).getIcon());
            viewHolder.text.setText(newsArrayList.get(position).getContent());
        }
        return view;
    }



    static class ViewHolder{
        ImageView icon;
        TextView text;
    }
}
