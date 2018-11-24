package com.example.wechatui_design.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wechatui_design.Activity.ChatActivity;
import com.example.wechatui_design.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jacky on 2018/11/13.
 */

public class MessageListActivity extends AppCompatActivity{
    private ListView lv;
    //集合
    private List<Message> messagetlist=new ArrayList<Message>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_listview);

        //循环读取数据，模仿数据库
        Message father=new Message(R.drawable.image1,"老爸","最近过的还好吗？","13:12");
            messagetlist.add(father);
        Message mather =new Message(R.drawable.image2,"老妈","钱还够吗？","周三");
        messagetlist.add(mather);
        Message brather =new Message(R.drawable.image3,"林杰","有空一起出来聚聚呗","周一");
        messagetlist.add(brather);
        Message parent =new Message(R.drawable.image4,"张凡","这道题莫名其妙","周日");
        messagetlist.add(parent);


        //查找listView1对象
        lv=(ListView)findViewById(R.id.wechat_listview);

        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {

                return messagetlist.size();//集合的大小
            }
            //每一个item项，返回一次界面
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view=null;
                //布局不变，数据变

                //如果缓存为空，我们生成新的布局作为1个item
                if(convertView==null)
                {
                    Log.i("info","没有缓存，重新生成"+position);
                    LayoutInflater ter=MessageListActivity.this.getLayoutInflater();
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view=ter.inflate(R.layout.wechat_message,null);
                }
                else
                {
                    Log.i("info","有缓存，不需要重新生成"+position);
                    view=convertView;
                }
                Message m=messagetlist.get(position);
                //读取数据
                ImageView img = (ImageView) view.findViewById(R.id.icon_image);
                img.setImageResource(m.getImageId());

                TextView tv1=(TextView)view.findViewById(R.id.icon_name);
                tv1.setText(m.getName() );
                tv1.setTextSize(15);
                TextView tv2=(TextView)view.findViewById(R.id.icon_message);
                tv2.setText(m.getMesseng());
                tv2.setTextSize(12);
                TextView tv3=(TextView)view.findViewById(R.id.icon_date);
                tv3.setText(m.getDate());
                tv3.setTextSize(12);
                return view;

            }

            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public Object getItem(int arg0) {
                // TODO Auto-generated method stub
                return null;
            }
        });

        /**
         * 设置listview点击事件
         */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Message message = messagetlist.get(position);

                switch (adapterView.getId()){
                    case R.id.wechat_listview:
                       Intent intent = new Intent(MessageListActivity.this,ChatActivity.class);
                        intent.putExtra("name",message.getName());
                        intent.putExtra("message",message.getMesseng());
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }

            }
        });
    }

}