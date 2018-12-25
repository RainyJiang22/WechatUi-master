package com.example.mychat_master.DB;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mychat_master.Activity.ChatActivity;
import com.example.mychat_master.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<Message> msgList;
    Context context;
    //1.Adapter需要List作为它的唯一关键属性
    //在实例化Adapter时传入List具体数据
    public MessageAdapter(List<Message> msgList,Context context) {
        this.msgList = msgList;
        this.context=context;
    }

    //2.定义ViewHolder(视图容器)
    //里面装的是条目中的所有控件
    //条目中控件的声明和绑定
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_head;
        TextView friend;
        TextView message;
        TextView time;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            iv_head=itemView.findViewById(R.id.icon_image);
            friend=itemView.findViewById(R.id.icon_name);
            message=itemView.findViewById(R.id.icon_message);
            time=itemView.findViewById(R.id.icon_date);
        }
    }

    //3.创建ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //将条目布局文件填充成View对象
        View itemView= View.inflate(parent.getContext(),R.layout.wechat_message,null);
        ViewHolder holder=new ViewHolder(itemView);
        return holder;
    }

    //4.给相应ViewHolder中的控件设置数据内容
    //数据从List中第position个元素中拿到
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Message msg=msgList.get(position);
        holder.iv_head.setImageResource(msg.getImg_head());
        holder.friend.setText(msg.getFriend());
        holder.message.setText(msg.getMsg());
        holder.time.setText(msg.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), ChatActivity.class);
                intent.putExtra("friend",msg.friend);
                ((Activity)view.getContext()).startActivityForResult(intent,1);

            }
        });
        holder.iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "你点击了"+msg.getFriend()+"头像", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //5.获取条目个数=List元素个数
    @Override
    public int getItemCount() {
        return msgList.size();
    }
}

