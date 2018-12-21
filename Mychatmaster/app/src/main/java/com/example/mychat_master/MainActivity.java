package com.example.mychat_master;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.mychat_master.Common.ActionItem;
import com.example.mychat_master.Common.AddPopWindow;
import com.example.mychat_master.Common.TitlePopup;
import com.example.mychat_master.Fragment.ContactlistFragment;
import com.example.mychat_master.Fragment.FindFragment;
import com.example.mychat_master.Fragment.ProfileFragment;
import com.example.mychat_master.Fragment.WeixinFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private TextView txt_title;
    private ImageView img_right;
    private TextView txt_left;


   private ViewPager viewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;


    //定义LinearLayout
    private LinearLayout mTabWeixin;
    private LinearLayout mTabContaclist;
    private LinearLayout mTabFriends;
    private LinearLayout mTabProfile;


    //定义ImageButton
    private ImageButton mImgWeixin;
    private ImageButton mImgContactlist;
    private ImageButton mImgFriends;
    private ImageButton mImgProfiles;

    //定义TextView
    private TextView tv_weixin;
    private TextView tv_contactlist;
    private TextView tv_friends;
    private TextView tv_profile;


    //定义标题栏弹窗
    private TitlePopup titlePopup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //关闭手机页面标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.wechat_main);


        //初始化视图
        initView();

        //初始化点击事件
        initEvent();

        setSelected(0);

        initPopWindow();
    }



    private void initEvent() {
          mTabWeixin.setOnClickListener(this);
          mTabFriends.setOnClickListener(this);
          mTabContaclist.setOnClickListener(this);
        mTabProfile.setOnClickListener(this);
    }

    private void initView() {
       //初始化控件
        txt_title = findViewById(R.id.txt_title);
        img_right = findViewById(R.id.img_right);
        txt_left = findViewById(R.id.txt_left);

        //初始化viewpager
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);


        //初始化LinearLayout
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabContaclist = (LinearLayout) findViewById(R.id.id_tab_contactlist);
        mTabFriends = (LinearLayout) findViewById(R.id.id_tab_friends);
        mTabProfile = (LinearLayout) findViewById(R.id.id_tab_profile);


        //初始化ImageButton
        mImgWeixin = (ImageButton) findViewById(R.id.ib_weixin);
        mImgContactlist = (ImageButton) findViewById(R.id.ib_contactlist);
        mImgFriends = (ImageButton) findViewById(R.id.ib_findfriends);
        mImgProfiles = (ImageButton) findViewById(R.id.ib_profile);


        //初始化TextView
        tv_weixin = (TextView) findViewById(R.id.tv_weixin);
        tv_contactlist = (TextView) findViewById(R.id.tv_contactlist);
        tv_friends = (TextView)findViewById(R.id.tv_findfriends);
        tv_profile = (TextView) findViewById(R.id.tv_profile);


      mFragments  = new ArrayList<Fragment>();
        Fragment mTabweixin = new WeixinFragment();
        Fragment mTabcontactlist = new ContactlistFragment();
        Fragment mTabFriend =  new FindFragment();
        Fragment mTabProfile = new ProfileFragment();
        mFragments.add(mTabweixin);
        mFragments.add(mTabcontactlist);
        mFragments.add(mTabFriend);
        mFragments.add(mTabProfile);


        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int arg0) {
                return  mFragments.get(arg0);
            }

            @Override
            public int getCount() {
               return mFragments.size();
            }
        };

        viewPager.setAdapter(mAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int currentItem = viewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initPopWindow() {
        //实例化标题栏弹窗
       titlePopup = new TitlePopup(this, ViewGroup.LayoutParams.WRAP_CONTENT,
               ViewGroup.LayoutParams.WRAP_CONTENT);
        titlePopup.setItemOnClickListener(onitemClick);
        //给标题栏弹窗添加子类
        titlePopup.addAction(new ActionItem(this,"发起群聊",R.drawable.icon_menu_group));
        titlePopup.addAction(new ActionItem(this,"添加朋友",R.drawable.icon_menu_addfriend));
        titlePopup.addAction(new ActionItem(this,"扫一扫",R.drawable.icon_menu_sao));
        titlePopup.addAction(new ActionItem(this, "收钱", R.drawable.abv));


    }


    private TitlePopup.OnItemOnClickListener onitemClick = new TitlePopup.OnItemOnClickListener() {

        @Override
        public void onItemClick(ActionItem item, int position) {
            // mLoadingDialog.show();
            switch (position) {
                case 1:
                    break;
            }
        }
    };


    public void setTab(int i) {

        resetImgs();
        img_right.setVisibility(View.GONE);
        switch (i){
            case 0:
                //微信图标渐变色
                 mImgWeixin.setImageResource(R.drawable.weixin_pressed);
                tv_weixin.setTextColor(getResources().getColor(R.color.textpressed));
                txt_title.setText("微信");
                txt_title.setVisibility(View.VISIBLE);
                txt_left.setVisibility(View.GONE);
                img_right.setVisibility(View.VISIBLE);
                img_right.setImageResource(R.drawable.icon_add);
                img_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AddPopWindow addPopWindow =  new AddPopWindow(MainActivity.this);
                        addPopWindow.showPopupWindow(img_right);
                    }
                });
                 break;
            case 1:
                 mImgContactlist.setImageResource(R.drawable.contact_list_pressed);
                tv_contactlist.setTextColor(getResources().getColor(R.color.textpressed));
                txt_title.setVisibility(View.VISIBLE);
                txt_left.setVisibility(View.GONE);
                txt_title.setText("通讯录");
                img_right.setVisibility(View.VISIBLE);
                img_right.setImageResource(R.drawable.icon_groupinfo);
                break;
            case 2:
                mImgFriends.setImageResource(R.drawable.find_pressed);
                tv_friends.setTextColor(getResources().getColor(R.color.textpressed));
                txt_title.setVisibility(View.VISIBLE);
                txt_left.setVisibility(View.GONE);
                txt_title.setText("发现");
                break;
            case 3:
                mImgProfiles.setImageResource(R.drawable.profile_pressed);
                tv_profile.setTextColor(getResources().getColor(R.color.textpressed));
                txt_title.setVisibility(View.VISIBLE);
                txt_left.setVisibility(View.GONE);
                txt_title.setText("我");
                break;
        }

    }


    //点击之前呈现暗色
    private void resetImgs() {

       mImgWeixin.setImageResource(R.drawable.weixin_normal);
        mImgFriends.setImageResource(R.drawable.find_normal);
        mImgContactlist.setImageResource(R.drawable.contact_list_normal);
        mImgProfiles.setImageResource(R.drawable.profile_normal);


        tv_weixin.setTextColor(getResources().getColor(R.color.textnormal));
        tv_contactlist.setTextColor(getResources().getColor(R.color.textnormal));
        tv_friends.setTextColor(getResources().getColor(R.color.textnormal));
        tv_profile.setTextColor(getResources().getColor(R.color.textnormal));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.id_tab_weixin:

                setSelected(0);
                break;
            case R.id.id_tab_contactlist:
                setSelected(1);
                break;
            case R.id.id_tab_friends:
                setSelected(2);
                break;
            case R.id.id_tab_profile:
                setSelected(3);
                break;

            default:
                break;
        }
    }

    public void setSelected(int i) {
        setTab(i);
        viewPager.setCurrentItem(i);
    }
}
