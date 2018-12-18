package com.example.wechatui_design.Common;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Jacky on 2018/11/9.
 */

/**
 * 对视图的一些性能优化
 */
public class ViewHolder {
    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view,int id){
        /**
         * 我们需要的是弹窗，SparseArray相对于HashMap的使用，它是Android特定的api，
         *
         * 使用稀疏数组可以更加节省内春空间的使用，SparseArray也是以key和value进行保存
         * 使用的时候只需要指定value的类型即可
         */
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null){
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }

        View childView = viewHolder.get(id);
        if (childView == null){
            childView = view.findViewById(id);
            viewHolder.put(id,childView);
        }
        return (T) childView;
    }
}
/**
 * 使用方法： 在getView里这样 ImageView bananaView = ViewHolder.get(convertView,
 * R.id.banana);
 */