package com.group.yztcedu.fblife.main.home.tabhome;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.main.home.bean.HomeViewPagerNewsBean;

import java.util.List;


public class MyAdapter extends PagerAdapter {
    public List<HomeViewPagerNewsBean> mNews;
    public MyAdapter( List<HomeViewPagerNewsBean> news){
        this.mNews = news;
    }
    @Override
    public int getCount() {
        return mNews!=null?mNews.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv  =new ImageView(container.getContext());
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        String imgUrl = mNews.get(position).getPhoto();
        Glide.with(container.getContext()).load(imgUrl).into(iv);
        //将iv添加到viewPager
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((ImageView) object);

    }
}
