package com.group.yztcedu.fblife.main.video;


import com.group.yztcedu.fblife.main.home.bean.VideoBean;
import com.group.yztcedu.fblife.main.video.videoutils.HttpUtils;

import java.util.HashMap;

public class VideoModle implements VideoContract.Modle{

    @Override
    public void getVideo(HashMap<String, String> params,HttpUtils.HttpCallBack<VideoBean> callBack) {
        HttpUtils.getInstance().getVideoBeanData(params,callBack);
    }
}
