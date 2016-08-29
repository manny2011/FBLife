package com.group.yztcedu.fblife.main.forum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.forum.entity.BbsinfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class AllPlatesAdapter extends BaseExpandableListAdapter {

    Context mContext;
    List<BbsinfoBean> mList;
    public AllPlatesAdapter(Context context, List<BbsinfoBean> list){
        mContext=context;
        mList=list;
    }
    @Override
    public int getGroupCount() {
        return mList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mList.get(i).getSub().size();
    }

    @Override
    public Object getGroup(int i) {
        return mList.get(i).getName();
    }

    @Override
    public Object getChild(int i, int i1) {
        return mList.get(i).getSub().get(i).getName();
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

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(mContext).inflate(R.layout.forum_expand_group_item_layout, null);
        ImageView imageView = (ImageView) view1.findViewById(R.id.forum_expand_child_image);
        TextView textView= (TextView) view1.findViewById(R.id.forum_expand_child_name);
        String text=mList.get(i).getName();
        if(text!=null){
            textView.setText(text);
        }
        textView.setText(text);
        return view1;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {


        ForumCustomExpandListview expandableListView = new ForumCustomExpandListview(mContext);
        List<String> list=new ArrayList<>();
        /**父数据源*/
        String text=mList.get(i).getSub().get(i1).getName();
        /**子数据源*/
        for(int j = 0;j<5;j++){
            list.add("BJ40");
        }
        ForumSecondExpandAdapter secondAdapter = new ForumSecondExpandAdapter(mContext,text,list);
        expandableListView.setAdapter(secondAdapter);
        return expandableListView;
        /**********************子视图返回一个expandablelistview ****************************/
//        View view1 = LayoutInflater.from(mContext).inflate(R.layout.forum_expand_second_layout, null);
//        ExpandableListView secondExpandView= (ExpandableListView) view1.findViewById(R.id.forum_expand_second);







    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
