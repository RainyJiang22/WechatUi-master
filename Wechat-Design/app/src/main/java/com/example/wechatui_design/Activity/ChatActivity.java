package com.example.wechatui_design.Activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wechatui_design.Chat.News;
import com.example.wechatui_design.Chat.NewsAdapter;
import com.example.wechatui_design.List.MessageListActivity;
import com.example.wechatui_design.R;

import java.util.ArrayList;

/**
 * Created by Jacky on 2018/11/17.
 */

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

     private TextView txt_left;
     private TextView txt_title;
     private ImageView img_back;

     private ArrayList<News> newsArrayList;
     private NewsAdapter newsAdapter;
     private EditText chatEditView;
     private ListView chatListView;
     private Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_chat);


        initControls();
        setListener();

    }


    /**
     * 设置监听器
     */
    private void setListener() {
       img_back.setOnClickListener(this);
    }


    /**
     * 实例化控件
     */
    private void initControls() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String message = intent.getStringExtra("message");

        //将标题变为联系人名字
        txt_left = (TextView) findViewById(R.id.txt_left);
        txt_left.setVisibility(View.VISIBLE);

        //隐藏主标题
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setVisibility(View.GONE);

        txt_left.setText(name);
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);


        chatListView = (ListView) findViewById(R.id.list_item);
        chatEditView = (EditText) findViewById(R.id.edit_send);
        newsArrayList = new ArrayList<>();
        initMessage();
        newsAdapter = new NewsAdapter(newsArrayList,ChatActivity.this);
        chatListView.setAdapter(newsAdapter);


        send = (Button) findViewById(R.id.btn_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = chatEditView.getText().toString();
                if(!"".equals(content)){
                    News news = new News(1,content, BitmapFactory.decodeResource(getResources(),R.drawable.image4));
                    newsArrayList.add(news);
                    newsAdapter.notifyDataSetChanged();
                    chatListView.setSelection(newsArrayList.size());
                    chatEditView.setText("");
                }
            }
        });

    }

    private void initMessage() {
            String name = getIntent().getStringExtra("name");
        if (name.equals("老爸")){
            News message1 = new News(0,"最近过的还好吗?", BitmapFactory.decodeResource(getResources(),R.drawable.image1));
            newsArrayList.add(message1);
            News message2 = new News(1,"挺好的，爸",BitmapFactory.decodeResource(getResources(),R.drawable.image4));
            newsArrayList.add(message2);
        }
        else if(name.equals("老妈")){
            News message1 = new News(0,"钱还够吗？", BitmapFactory.decodeResource(getResources(),R.drawable.image2));
            newsArrayList.add(message1);
            News message2 = new News(1,"够呀，自己还赚了点钱",BitmapFactory.decodeResource(getResources(),R.drawable.image4));
            newsArrayList.add(message2);
        }
        else if(name.equals("林杰")){
            News message1 = new News(0,"有空一起出来聚聚呗", BitmapFactory.decodeResource(getResources(),R.drawable.image3));
            newsArrayList.add(message1);
            News message2 = new News(1,"行啊，时间地点你定",BitmapFactory.decodeResource(getResources(),R.drawable.image4));
            newsArrayList.add(message2);
//            News message3 = new News(0,"明天晚上7点", BitmapFactory.decodeResource(getResources(),R.drawable.image3));
//            newsArrayList.add(message3);
//            News message4 = new News(1,"好的，no problem",BitmapFactory.decodeResource(getResources(),R.drawable.image4));
//            newsArrayList.add(message4);
        }
        else if(name.equals("张凡")){
            News message1 = new News(0,"这道题莫名其妙", BitmapFactory.decodeResource(getResources(),R.drawable.image4));
            newsArrayList.add(message1);
            News message2 = new News(1,"这样咩，是老师上课那道",BitmapFactory.decodeResource(getResources(),R.drawable.image4));
            newsArrayList.add(message2);
//            News message3 = new News(0,"对呀", BitmapFactory.decodeResource(getResources(),R.drawable.image4));
//            newsArrayList.add(message3);
//            News message4 = new News(1,"稍等我把我的解题思路发你一下呗",BitmapFactory.decodeResource(getResources(),R.drawable.image4));
//            newsArrayList.add(message4);
        }
    }



    @Override
    public void onClick(View view) {
          switch (view.getId()){

              case R.id.img_back:
                  Intent intent = new Intent(ChatActivity.this, MessageListActivity.class);
                  overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                  startActivity(intent);
                 // finish();
                  break;
              default:
                  break;
          }
    }
}

