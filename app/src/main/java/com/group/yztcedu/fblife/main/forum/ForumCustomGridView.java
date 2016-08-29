package com.group.yztcedu.fblife.main.forum;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ForumCustomGridView extends GridView {
    public ForumCustomGridView(Context context) {
        super(context);
    }

    public ForumCustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ForumCustomGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //不出现滚动条
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
