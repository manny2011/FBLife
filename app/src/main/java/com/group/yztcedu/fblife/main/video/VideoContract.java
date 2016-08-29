package com.group.yztcedu.fblife.main.video;


import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.home.bean.VideoBean;
import com.group.yztcedu.fblife.main.home.bean.VideoInfoBean;
import com.group.yztcedu.fblife.main.video.videoutils.HttpUtils;

import java.util.HashMap;
import java.util.List;

public class VideoContract {
    public interface View extends IBaseView{
        void onSuccessGetVideoInfo(List<VideoInfoBean> videoInfoBeen);
        void onFailGetVideoInfo(String mag);
    }
    public interface Modle extends IBaseModel{
        void getVideo(HashMap<String,String> params, HttpUtils.HttpCallBack<VideoBean> callBack);

    }
    public interface Presenter extends IBasePresenter{
        void initData(HashMap<String,String> params);
    }
}
