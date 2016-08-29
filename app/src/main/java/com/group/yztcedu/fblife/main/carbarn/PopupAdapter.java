package com.group.yztcedu.fblife.main.carbarn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.carbarn.entity.SeriesBean;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class PopupAdapter extends ArrayAdapter<SeriesBean> {


    public PopupAdapter(Context context, int resource, List<SeriesBean> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SeriesBean bean = getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.garage_popup_list_item_layout,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(bean.getName());
        String seriesPriceMin = bean.getSeriesPriceMin();
        String seriesPriceMax = bean.getSeriesPriceMax();
        DecimalFormat decimalFormat =new DecimalFormat("0.00");

        seriesPriceMin=String.valueOf(decimalFormat.format(Integer.parseInt(seriesPriceMin)/10000));
        seriesPriceMax=String.valueOf(decimalFormat.format(Integer.parseInt(seriesPriceMax)/10000));
        viewHolder.price.setText(seriesPriceMin+"-"+seriesPriceMax+"万");
        Glide.with(getContext()).load(bean.getPhoto()).into(viewHolder.image);
        return convertView;
    }

    static class ViewHolder{
        TextView name,price;
        ImageView image;
        public ViewHolder(View view){
            name= (TextView) view.findViewById(R.id.model_name);
            price= (TextView) view.findViewById(R.id.model_price);
            image = (ImageView) view.findViewById(R.id.model_pic);

        }
    }
}
