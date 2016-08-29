package com.group.yztcedu.fblife.main.video.videoutils;

import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.bean.VideoBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface VideoBeanService {
    @GET(UrlConfig.Path.HOME_URL)
    Call<VideoBean> getHome(@QueryMap() HashMap<String, String> params);
}
