package com.example.mychat_master.DB;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    static List<Activity> activityList=new ArrayList();
    public static void add(Activity activity){
        activityList.add(activity);
    }
    public static void remove(Activity activity){
        activityList.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity:activityList){
            if(!activity.isFinishing())
                activity.finish();
        }
    }
}
