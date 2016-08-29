package com.group.yztcedu.fblife.main.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.home.bean.VideoInfoBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class VideoAdapter extends BaseAdapter {
    private List<VideoInfoBean> mList;

    public VideoAdapter(List<VideoInfoBean> list) {
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
    public View getView(int i, View view, final ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_list_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        VideoInfoBean videoInfoBean = mList.get(i);
        String qrurlUrl = videoInfoBean.getQrurl();
        final String playUrl = videoInfoBean.getVideoUrl().getMainUrl();
        final String title = videoInfoBean.getTitle();
        String playTime = videoInfoBean.getVideoDuration();
        String time = videoInfoBean.getPublishtime();
        getTime(time, holder.tvtime);
        //getPlayTime(playTime, holder.tvPlayTime);
              boolean setUp = holder.jcVideoPlayerStandard.setUp(playUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, title);
        if(setUp){

            ImageLoader.getInstance().displayImage(qrurlUrl,holder.jcVideoPlayerStandard.thumbImageView);
        }else{
            holder.tvPlayTime.setVisibility(view.GONE);
        }
        holder.tvTitle.setText(title);
        return view;
    }

    class ViewHolder {
        private TextView tvTitle, tvtime, tvPlayTime;
        private JCVideoPlayerStandard jcVideoPlayerStandard;

        public ViewHolder(View view) {
            tvTitle = (TextView) view.findViewById(R.id.video_title_tv);
            tvtime = (TextView) view.findViewById(R.id.video_time_tv);
            //tvPlayTime = (TextView) view.findViewById(R.id.video_play_time);
            jcVideoPlayerStandard = (JCVideoPlayerStandard) view.findViewById(R.id.video_view);

        }

    }
    public void getPlayTime(String playTime, TextView textView) {
        int time = Integer.parseInt(playTime);
        int mill = time % 60;
        int minute = time / 60;
        if (minute < 10) {
            if (minute > 0) {
                if (mill > 10) {
                    textView.setText("0" + minute + ":" + mill);
                } else {
                    textView.setText("0" + minute + ":" + "0" + mill);
                }
            } else {
                if (mill > 10) {
                    textView.setText("0" + minute + ":" + mill);
                } else {
                    textView.setText("0" + minute + ":" + "0" + mill);
                }
            }

        } else {
            if (mill > 10) {
                textView.setText(minute + ":" + mill);
            } else {
                textView.setText(minute + ":" + "0" + mill);
            }
        }
    }

    public void getTime(String posttime, TextView textView) {
        long parseLong = Long.parseLong(posttime);
        long times = parseLong * 1000;
        long time = System.currentTimeMillis() - (parseLong * 1000);
        long mill = (long) Math.ceil(time / 1000);
        long minute = (long) Math.ceil(time / 60 / 1000.0f);
        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);
        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);
        if (day > 10) {
            Date date = new Date(times);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = sdf.format(date);
            String s1 = s.substring(0, 10);
            textView.setText(s1);
        } else if (day - 1 > 0) {
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
