package com.example.wechatui_design.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.wechatui_design.Activity.MyInfoActivity;
import com.example.wechatui_design.R;

/**
 * Created by Jacky on 2018/10/21.
 */

public class ProfileFragment  extends Fragment{

    private RelativeLayout re_myinfo;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_profile,container,false);

//       re_myinfo = view.findViewById(R.id.re_myinfo);
//       re_myinfo.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Intent intent = new Intent(getActivity(),MyInfoActivity.class);
//               startActivity(intent);
//           }
//       });
    }
}
