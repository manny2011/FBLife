package com.group.yztcedu.fblife.main.home.tabhome.homehttputils;

import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.bean.HomeBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/4.
 */
public interface HomeBeanService {
    @GET(UrlConfig.Path.HOME_URL)
    Call<HomeBean> getHome(@QueryMap() HashMap<String, String> params);
}
