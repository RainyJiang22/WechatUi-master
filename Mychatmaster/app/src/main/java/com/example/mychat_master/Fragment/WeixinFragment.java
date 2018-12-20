package com.example.mychat_master.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mychat_master.R;

/**
 * Created by Jacky on 2018/10/21.
 */

public class WeixinFragment extends Fragment {

     private ListView lv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weixin,container,false);


    }

}
