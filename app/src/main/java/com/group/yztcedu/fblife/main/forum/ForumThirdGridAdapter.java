package com.group.yztcedu.fblife.main.forum;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/7.
 */
public class ForumThirdGridAdapter extends ArrayAdapter<String> {

    Context mContext;
    List<String> mList;
    public ForumThirdGridAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mList=objects;
    }
    /**arrayAdapter是如何知道我需要返回多少个View? 应该是根据我传入的数据源的大小来判断知道要循环多少次getview()方法;*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.forum_grid_item_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.forum_grid_item_text);
        textView.setText(mList.get(position));
        if(textView!=null){
            Log.i("TAG","textview is "+textView.toString());
        }
        Log.i("TAG",mList.get(position));
        return view;
    }
}
