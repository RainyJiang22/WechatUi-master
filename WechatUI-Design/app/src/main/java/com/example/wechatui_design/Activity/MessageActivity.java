package com.example.wechatui_design.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wechatui_design.Adapter.ItemImage;
import com.example.wechatui_design.Adapter.MessageAdapter;
import com.example.wechatui_design.R;
import com.example.wechatui_design.view.MyRecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jacky on 2018/11/15.
 */

public class MessageActivity extends AppCompatActivity {
    private List<ItemImage> itemImageList = new ArrayList<>();
//    private List<Integer> imageData = new ArrayList<>();
//    private List<Integer> nameData = new ArrayList<>();

    private MyRecyclerView myRecyclerView;
    private ImageView mImg;
    private List<Integer> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recylerview_message);
       //加载数据
        init();


        myRecyclerView = (MyRecyclerView) findViewById(R.id.recycler_main);
        mImg = (ImageView) findViewById(R.id.id_content);


        /**
         * 另外创建一个List存储放大的图片
         */


        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.image1,
                R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image3,
                R.drawable.image2, R.drawable.image3, R.drawable.image2, R.drawable.image1));
        /**
         * 创建一个linearlayoutmaneger对象，并将他设置到recyclerview当中。layoutmanager用于指定
         * recyclerview的布局方式，这里是线性布局的意思。可以实现和listview类似的效果。
         * （注意如果没有绑定，会报错）
         *
         * 接下来我们创建了MessageAdapter的实例，并将数据传进去
         *
         * 我们使用了相关存储列表进行存储相关资源信息
         */
        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(this);
        //设置水平滚动
         linearlayoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        myRecyclerView.setLayoutManager(linearlayoutmanager);
//        MessageAdapter adpter = new MessageAdapter(itemImageList,imageData,nameData);
        MessageAdapter adpter = new MessageAdapter(itemImageList);
        adpter.setOnItemClickListener(new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MessageActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                mImg.setImageResource(mDatas.get(position));
            }
        });
        //加载适配器
        myRecyclerView.setAdapter(adpter);

        //滚动监听事件
        myRecyclerView.setOnItemScrollChangeListener(new MyRecyclerView.OnItemScrollChangeListener() {
            @Override
            public void onChange(View view, int position) {
                mImg.setImageResource(mDatas.get(position));
            }
        });
    }


    /**
     * 1.优化数据的时候，可以定义一个List 放入到ArrayList，
     * 通过asList将数据逐条加载进去,一般来说我们使用的大多数是进行存储图片资源
     *
     */

    //加载数据
    private void init() {

        ItemImage first = new ItemImage("First",R.drawable.image1);
        itemImageList.add(first);
        ItemImage second = new ItemImage("Second",R.drawable.image2);
        itemImageList.add(second);
        ItemImage third = new ItemImage("Third",R.drawable.image3);
        itemImageList.add(third);
        ItemImage fouth = new ItemImage("Fouth",R.drawable.image4);
        itemImageList.add(fouth);
        ItemImage five = new ItemImage("Five",R.drawable.image3);
        itemImageList.add(five);
        ItemImage six = new ItemImage("Six",R.drawable.image2);
        itemImageList.add(six);
        ItemImage seven = new ItemImage("Seven",R.drawable.image3);
        itemImageList.add(seven);
        ItemImage eight = new ItemImage("Eight",R.drawable.image2);
        itemImageList.add(eight);
        ItemImage nine = new ItemImage("Nine",R.drawable.image1);
        itemImageList.add(nine);
    }
}
