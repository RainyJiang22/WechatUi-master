package com.example.wechatui_design.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wechatui_design.R;
import com.example.wechatui_design.view.contactview.ContactAdapter;
import com.example.wechatui_design.view.contactview.DividerItemDecoration;
import com.example.wechatui_design.view.contactview.LetterView;

/**
 * Created by Jacky on 2018/10/21.
 */

public class ContactlistFragment  extends Fragment{

     private RecyclerView contactlist;
     private LinearLayoutManager layoutManager;
     private LetterView letterView;
     private ContactAdapter adapter;

    /**
     * 先暂时存在数组里面，后期会使用数据库
     */
    private String[] constactsName;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_contactlist,container,false);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        constactsName = new String[] {"张三丰", "郭靖", "黄蓉", "黄老邪", "赵敏", "123", "天山童姥", "任我行", "于万亭", "陈家洛", "韦小宝", "$6", "穆人清", "陈圆圆", "郭芙", "郭襄", "穆念慈", "东方不败", "梅超风", "林平之", "林远图", "灭绝师太", "段誉", "鸠摩智"};
        contactlist = getActivity().findViewById(R.id.contact_list);
        letterView = getActivity().findViewById(R.id.letter_view);
        layoutManager = new LinearLayoutManager(getActivity());


        contactlist.setLayoutManager(layoutManager);
        contactlist.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    //加载适配器
        contactlist.setAdapter(adapter);

        letterView.setCharacterListener(new LetterView.CharacterClickListener() {
            @Override
            public void clickCharacter(String character) {
                layoutManager.scrollToPositionWithOffset(adapter.getScrollPosition(character), 0);
            }

            @Override
            public void clickArrow() {
                layoutManager.scrollToPositionWithOffset(0, 0);
            }
        });
    }
}
