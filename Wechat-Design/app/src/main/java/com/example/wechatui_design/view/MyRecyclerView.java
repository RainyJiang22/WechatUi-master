package com.example.wechatui_design.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Jacky on 2018/11/16.
 */


/**
 * 我们自定义一个Recylerview
 */
public class MyRecyclerView extends RecyclerView {


    /**
     * 记录当前第一个view
     */
    private View mCurrentView;

    public MyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setOnScrollListener(this);
    }


    private void setOnScrollListener(MyRecyclerView myRecyclerView) {
    }

    /**
     * 滚动时候调用的接口
     */
    public interface OnItemScrollChangeListener {
        void onChange(View view, int position);
    }

    private OnItemScrollChangeListener onItemScrollChangeListener;

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener onItemScrollChangeListener) {
        this.onItemScrollChangeListener = onItemScrollChangeListener;
    }




    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        mCurrentView = getChildAt(0);

        if (onItemScrollChangeListener != null) {
            onItemScrollChangeListener.onChange(mCurrentView, getChildPosition(mCurrentView));
        }
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
    }


    /**
     *滚动的时候，判断当前第一个view是否发生变化，发生的时候才回调
     * 回调函数需要注意的点:
     * 1.当参数不能返回null值，一旦返回null值不能滑动
     * @param e
     * @return
     */
    @Override
    public void onScrolled(int dx, int dy) {

        View newView = getChildAt(0);

        if (onItemScrollChangeListener != null)
        {
            if (newView != null && newView != mCurrentView)
            {
                mCurrentView = newView ;
                onItemScrollChangeListener.onChange(mCurrentView,
                        getChildPosition(mCurrentView));
            }
        }
    }


    /**
     * 触摸事件
     *
     * @param e
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {

        if (e.getAction() == MotionEvent.ACTION_MOVE) {
            mCurrentView = getChildAt(0);
            if (onItemScrollChangeListener != null) {
                onItemScrollChangeListener.onChange(mCurrentView, getChildPosition(mCurrentView));
            }
        }
        return super.onTouchEvent(e);
    }



    /**
     * 触摸事件
     */
//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//
//        if(e.getAction() == MotionEvent.ACTION_MOVE){
//            mCurrentView = getChildAt(0);
//            if (onItemScrollChangeListener != null){
//                onItemScrollChangeListener.onChange(mCurrentView,getChildPosition(mCurrentView));
//            }
//        }
//
//        return super.onTouchEvent(e);
//    }
}
