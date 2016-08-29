package com.group.yztcedu.fblife.main.forum;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ForumSecondExpandAdapter extends BaseExpandableListAdapter {

    /**
     * 因JOSON解析不了,三级数据源为模拟数据
     */
    Context mContext;
//    List<String> mList;
    String groupTitle;

    public ForumSecondExpandAdapter(Context context, String groupTitle, List<String> list) {
        this.mContext = context;
//        this.mList = list;
        this.groupTitle = groupTitle;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 暂时不考虑listview的优化
     */
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(mContext).inflate(R.layout.forum_expand_child_item_layout, null);
        TextView textView = (TextView) view1.findViewById(R.id.forum_expand_child_name);
        if (groupTitle != null) {
            textView.setText(groupTitle);
        }
        Log.i("TAG","group executed!");
        return view1;
    }
/**关键问题出在这个地方:上面的都对*/
/**下面的方法根本就没有执行!!!!!SHIT*/

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Log.i("TAG","执行了没有?");
        GridView gridView = new ForumCustomGridView(mContext);
        gridView.setNumColumns(2);
        List<String> list = new ArrayList<>();
        for(int j=0;j<10;j++){
            list.add("北京40");
        }
        ForumThirdGridAdapter adapter = new ForumThirdGridAdapter(mContext,0, list);
        gridView.setAdapter(adapter);

        /*为什么放一个textview也显示不出来*/
        return gridView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
