package com.group.yztcedu.fblife.main.carbarn;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.config.UrlConfig_BrandImage;
import com.group.yztcedu.fblife.main.carbarn.entity.Vehicle;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class VehicleAdapter extends BaseAdapter implements SectionIndexer {
    private Context mContext;
    private List<Vehicle> mList;

    public VehicleAdapter(Context context, List<Vehicle> list){
        this.mContext=context;
        this.mList=list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.garage_item_layout,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        int section=getSectionForPosition(i);
        int position=getPositionForSection(section);
        viewHolder.textView.setText(mList.get(i).getName());
        Glide.with(mContext).load(UrlConfig_BrandImage.base_url+mList.get(i).getBrand()+".jpg")
                .into(viewHolder.imageView);
        if(position==i){
            viewHolder.linearLayout.setVisibility(View.VISIBLE);
            viewHolder.textView_title.setText(mList.get(i).getSortedKey());
            Log.i("TAG","执行了适配器");
        }else{
            viewHolder.linearLayout.setVisibility(View.GONE);

        }

        return view;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView textView,textView_title;
        LinearLayout linearLayout;

        public ViewHolder(View view){
            imageView= (ImageView) view.findViewById(R.id.garage_vehicle_image);
            textView= (TextView) view.findViewById(R.id.garage_brand);
            textView_title= (TextView) view.findViewById(R.id.garage_sortedKey);
            linearLayout= (LinearLayout) view.findViewById(R.id.garage_title);
        }
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    @Override
    public int getPositionForSection(int i) {
        for(int j=0;j<mList.size();j++){
            String t=mList.get(j).getSortedKey();
            char s=t.charAt(0);
            if(s==i){
                return j;
                //直接跳此方法,返回结果;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int i) {
        return mList.get(i).getSortedKey().charAt(0);
    }
}
