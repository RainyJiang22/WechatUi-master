package com.example.mychat_master.Activity;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mychat_master.DB.ActivityCollector;
import com.example.mychat_master.Fragment.WeixinFragment;
import com.example.mychat_master.R;
import com.example.mychat_master.Util.News;
import com.example.mychat_master.Util.NewsAdapter;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

   private TextView txt_left;
   private TextView txt_title;
   private TextView txt_right;
   private ImageView img_back;



   private ArrayList<News> newsArrayList;
   private NewsAdapter newsAdapter;
   private EditText chatEditView;
   private ListView chatListView;
   private Button send;
   private String friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.add(this);
        setContentView(R.layout.wechat_chat);


       initControls();

    }


    /**
     * 设置监听器
     */
    private void setListener()
    {
        img_back.setOnClickListener(this);
    }


    /**
     * 实例化控件
     */
    private void initControls() {
        ////获取上一界面传递过来的数据显示在TextView上
        Intent intent = getIntent();
      friend = intent.getStringExtra("friend");

        //将标题变为联系人名字
        txt_left = (TextView) findViewById(R.id.txt_left);
        txt_left.setVisibility(View.VISIBLE);
      //隐藏主标题
        txt_title = (TextView) findViewById(R.id.txt_title);
        txt_title.setVisibility(View.GONE);
        txt_left.setText(friend);
        img_back = findViewById(R.id.img_back);
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


    @Override
    public void onBackPressed() {

        Intent intent  =new Intent();
        if (chatEditView.getText().toString() != null){
            intent.putExtra("msg",chatEditView.getText().toString());
            intent.putExtra("friend",friend);
        }
        setResult(10,intent);
        finish();
    }

    /**
     * 插入数据
     */
    private void initMessage() {
        String name = getIntent().getStringExtra("friend");
        if (name.equals("老爸")){
            News message1 = new News(0,"最近过的还好吗?", BitmapFactory.decodeResource(getResources(),R.drawable.image1));
            newsArrayList.add(message1);
        }
        else if(name.equals("老妈")){
            News message1 = new News(0,"钱还够吗？", BitmapFactory.decodeResource(getResources(),R.drawable.image2));
            newsArrayList.add(message1);

        }
        else if(name.equals("林杰")){
            News message1 = new News(0,"有空一起出来聚聚呗", BitmapFactory.decodeResource(getResources(),R.drawable.image3));
            newsArrayList.add(message1);


        }
        else if(name.equals("张凡")){
            News message1 = new News(0,"这道题莫名其妙", BitmapFactory.decodeResource(getResources(),R.drawable.image4));
            newsArrayList.add(message1);
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.img_back:
                Intent intent = new Intent(ChatActivity.this, WeixinFragment.class);
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(this);
    }
}
