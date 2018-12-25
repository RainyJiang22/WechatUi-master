package com.example.mychat_master.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.mychat_master.Activity.MyInfoActivity;
import com.example.mychat_master.Activity.SettingActivity;
import com.example.mychat_master.R;
/**
 * Created by Jacky on 2018/10/21.
 */

public class ProfileFragment  extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_profile,container,false);
       return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //我的信息
        RelativeLayout re_myinfo = getActivity().findViewById(R.id.re_myinfo);
        re_myinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),MyInfoActivity.class));
            }
        });

        RelativeLayout re_setting = getActivity().findViewById(R.id.re_setting);
        re_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),SettingActivity.class));
            }
        });

    }
}
