package com.example.wechatui_design.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wechatui_design.R;

import java.util.List;

/**
 * Created by Jacky on 2018/11/14.
 */


/**
 * 这里是适配器，新建一个MessageAdapter类，让这个适配器继承RecyclerViewAdapter，并将泛型指定为MessageAdaper.ViewHolder
 * ViewHolder作为一个内部类
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<ItemImage> itemImageList;
    //新增List分别存放名字和图片，相当于数组
    private List<Integer> imageData;
    private List<Integer> nameData;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iconImage;
        TextView iconName;

        public ViewHolder(View itemView) {
            super(itemView);
            iconImage = (ImageView) itemView.findViewById(R.id.icon_image);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
        }
    }

    /***
     * itemclick的回调接口
     */
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 用于把展示的数据源传进来，并赋值给一个全局变量
     * @param itemImageList
     */
   public MessageAdapter(List<ItemImage> itemImageList){
//       this.imageData = imageData;
//       this.nameData = nameData;
       this.itemImageList = itemImageList;
   }

    /**
     * 创建ViewHolder实例，并把加载出来的布局传入构造函数，并将ViewHolder作为实例进行返回
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.wechat_message,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 用于对RecyclerView子项的数据进行赋值的，会在每个子项被滚动到屏幕内的时候执行，这里我们通过
     * position参数得到当前项的Fruit实例，然后再将数据设置到ViewHolder的Imageview和textview当中即可，
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
             ItemImage itemImage = itemImageList.get(position);
             holder.iconImage.setImageResource(itemImage.getImageId());
             holder.iconName.setText(itemImage.getName());


        //如果设置了回调值，我们下面设置点击事件
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }


    /**
     * 列表大小
     * @return
     */
    @Override
    public int getItemCount() {
        return itemImageList.size();
    }
}
