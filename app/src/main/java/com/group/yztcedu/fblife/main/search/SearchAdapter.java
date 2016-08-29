package com.group.yztcedu.fblife.main.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.search.bean.Searchinfobean;
import com.group.yztcedu.fblife.utils.TimeUtils;

import java.util.List;

/**
 * Created by Polaris on 2016/8/5.
 */
public class SearchAdapter extends BaseAdapter{
    private Context mContext;
    private List<Searchinfobean> list;
    public SearchAdapter(Context context,List<Searchinfobean> list) {
        this.mContext = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search,null);
            mHolder = new ViewHolder(convertView);
            convertView.setTag(mHolder);
        }else {
           mHolder= (ViewHolder) convertView.getTag();
        }

        mHolder.item_textView_title.setText(list.get(position).getTitle());
        mHolder.item_textView_content.setText(list.get(position).getContent());
        mHolder.item_textView_time.setText(TimeUtils.getTime(list.get(position).getDateline()));
        return convertView;

    }
    class ViewHolder{
        private TextView item_textView_title;
        private TextView item_textView_content;
        private TextView item_textView_time;
        public ViewHolder(View convertView){
            item_textView_title = (TextView) convertView.findViewById(R.id.item_textView_title);
            item_textView_content = (TextView) convertView.findViewById(R.id.item_textView_content);
            item_textView_time = (TextView) convertView.findViewById(R.id.item_textView_time);
        }
    }
    public void addAll(List<Searchinfobean> mList,Boolean flag){
        if (flag==true){
            list.clear();
        }
        list.addAll(mList);
        notifyDataSetChanged();
    }
}
