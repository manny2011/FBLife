package com.group.yztcedu.fblife.main.video;

import com.group.yztcedu.fblife.main.home.bean.VideoBean;
import com.group.yztcedu.fblife.main.video.videoutils.HttpUtils;

import java.util.HashMap;

public class VideoPresenter implements VideoContract.Presenter {
private VideoContract.Modle modle;
    private VideoContract.View view;
    public VideoPresenter(VideoContract.View view,VideoContract.Modle modle){
        this.view = view;
        this.modle = modle;
    }
    @Override
    public void initData(HashMap<String, String> params) {
        modle.getVideo(params, new HttpUtils.HttpCallBack<VideoBean>() {
            @Override
            public void onSuccess(VideoBean videoBean) {
                view.onSuccessGetVideoInfo(videoBean.getDatainfo());
            }
            @Override
            public void onFail() {
                view.onFailGetVideoInfo("网络连接错误");

            }
        });
    }
}
