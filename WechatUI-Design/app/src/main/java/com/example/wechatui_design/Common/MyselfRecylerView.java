package com.example.wechatui_design.Common;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.wechatui_design.view.MyRecyclerView;

/**
 * Created by Jacky on 2018/11/16.
 */

public class MyselfRecylerView extends RecyclerView {


    //记录第一个类
    private View CurrentView;



    public MyselfRecylerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnScrollListener(this);
    }


    public void setOnScrollListener(MyselfRecylerView myselfRecylerView){

    }

    /**
     * 滚动时候调用的接口
     */
    public interface  OnItemScrollChangeListener{
        void onChange(View view, int position);
    }

    private OnItemScrollChangeListener onItemScrollChangeListener;


    //实例化接口方法
    public void setOnItemScrollChangeListener(OnItemScrollChangeListener onItemScrollChangeListener) {
        this.onItemScrollChangeListener = onItemScrollChangeListener;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        CurrentView = getChildAt(0);

        //如果为空，就回调函数
        if (onItemScrollChangeListener != null){
            onItemScrollChangeListener.onChange(CurrentView,getChildPosition(CurrentView));
        }

    }



    @Override
    public void onScrolled(int dx, int dy) {

        View newView = getChildAt(0);

        if (onItemScrollChangeListener != null)
        {
            if (newView != null && newView != CurrentView)
            {
                CurrentView = newView ;
                onItemScrollChangeListener.onChange(CurrentView,
                        getChildPosition(CurrentView));
            }
        }
    }



//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//
//        if (e.getAction() == MotionEvent.ACTION_MOVE){
//
//            CurrentView = getChildAt(0);
//            if (onItemScrollChangeListener != null){
//                onItemScrollChangeListener.onChange(CurrentView,getChildPosition(CurrentView));
//            }
//        }
//
//        return super.onTouchEvent(e);
//    }


}
