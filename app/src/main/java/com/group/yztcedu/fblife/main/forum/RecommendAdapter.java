package com.group.yztcedu.fblife.main.forum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.forum.entity.App;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class RecommendAdapter extends ArrayAdapter<App> {
    private Context mContext;
    public RecommendAdapter(Context context, int resource, List<App> objects) {
        super(context, resource, objects);
        this.mContext=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.forum_recommend_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        App app = getItem(position);
        viewHolder.title.setText(app.getTitle());
        viewHolder.subTitle.setText(app.getStitle());
        viewHolder.forum.setText("论坛-"+app.getForumname());
        viewHolder.comment.setText(app.getComment());
        Glide.with(convertView.getContext()).load(app.getPhoto().get(0))
                .placeholder(R.mipmap.homepage_jxtj_listitem_imgbg)
                .into(viewHolder.imageView);
        return convertView;
    }
    static class ViewHolder{

        ImageView imageView;
        TextView title, subTitle, forum, comment;

        public ViewHolder(View itemView){
            imageView = (ImageView) itemView.findViewById(R.id.bbs_recommend_refresh_list_item_image);
            title = (TextView) itemView.findViewById(R.id.bbsrecomment_refresh_list_item_title);
            subTitle = (TextView) itemView.findViewById(R.id.bbs_recommend_refresh_list_item_stitle);
            forum = (TextView) itemView.findViewById(R.id.bbs_recomment_refresh_list_item_forum);
            comment = (TextView) itemView.findViewById(R.id.bbs_recomment_refresh_list_item_comment);

        }
    }
}
