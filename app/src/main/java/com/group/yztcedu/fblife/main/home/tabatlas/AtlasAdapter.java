package com.group.yztcedu.fblife.main.home.tabatlas;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.home.bean.AtlasInfoBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AtlasAdapter extends BaseAdapter {
    private List<AtlasInfoBean> mList;

    public AtlasAdapter(List<AtlasInfoBean> list) {
        this.mList = list;
    }

    @Override

    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mList != null ? mList.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_atlas_list_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        AtlasInfoBean atlasInfoBean = mList.get(i);
        String title = atlasInfoBean.getTitle();
        String comment = atlasInfoBean.getComment();
        String time = atlasInfoBean.getPublishtime();
        getTime(time, holder.tvTime);
        holder.tvName.setText(title);
        holder.tvComment.setText(comment + " 评论");
        List<String> photoUrls = atlasInfoBean.getPhoto();
        switch (photoUrls.size()) {
            case 1:
                String OneUrl = photoUrls.get(0);
                Glide.with(viewGroup.getContext()).load(OneUrl).placeholder(R.mipmap.logo_).into(holder.ivPhotoOne);
                break;
            case 3:
                OneUrl = photoUrls.get(0);
                String TwoUrl = photoUrls.get(1);
                String ThreeUrl = photoUrls.get(2);
                Glide.with(viewGroup.getContext()).load(OneUrl).placeholder(R.mipmap.logo_).into(holder.ivPhotoOne);
                Glide.with(viewGroup.getContext()).load(TwoUrl).placeholder(R.mipmap.logo_).into(holder.ivPhotoTwo);
                Glide.with(viewGroup.getContext()).load(ThreeUrl).placeholder(R.mipmap.logo_).into(holder.ivPhotoThree);
                break;
        }


        return view;
    }

    class ViewHolder {
        private ImageView ivPhotoOne, ivPhotoTwo, ivPhotoThree;
        private TextView tvComment, tvName, tvTime;

        public ViewHolder(View view) {
            ivPhotoOne = (ImageView) view.findViewById(R.id.tab_atlas_item_ivOne);
            ivPhotoTwo = (ImageView) view.findViewById(R.id.tab_atlas_item_ivTwo);
            ivPhotoThree = (ImageView) view.findViewById(R.id.tab_atlas_item_ivThree);
            tvName = (TextView) view.findViewById(R.id.tab_atlas_item_tvName);
            tvTime = (TextView) view.findViewById(R.id.tab_atlas_item_tvTime);
            tvComment = (TextView) view.findViewById(R.id.tab_atlas_item_tvComment);
        }
    }

    public void getTime(String posttime, TextView textView) {

        long parseLong = Long.parseLong(posttime);
        long times = parseLong*1000;
        long time = System.currentTimeMillis() - (parseLong * 1000);
        long mill = (long) Math.ceil(time / 1000);
        long minute = (long) Math.ceil(time / 60 / 1000.0f);
        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);
        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);
        if(day>10){
            Date date = new Date(times);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = sdf.format(date);
            String s1 = s.substring(5, 10);
            String s2 = s.substring(11,16);
            textView.setText(s1+" "+s2);
        }else if (day - 1 > 0) {
            textView.setText((day - 1) + "天前");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                textView.setText("一天前");
            } else {
                textView.setText((hour - 1) + "小时前");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                textView.setText("一小时前");
            } else {
                textView.setText((minute - 1) + "分钟前");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                textView.setText("一分钟前");
            } else {
                textView.setText((mill - 1) + "秒前");
            }
        } else {
            textView.setText("刚刚");
        }

    }

}
