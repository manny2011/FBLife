package com.group.yztcedu.fblife.main.forum;

import android.content.Context;
import android.widget.ExpandableListView;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ForumCustomExpandListview extends ExpandableListView {
    public ForumCustomExpandListview(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
