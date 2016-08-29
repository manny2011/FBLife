package com.group.yztcedu.fblife.main.home.tabatlas.atlashttputils;

import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.bean.AtlasBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface AtlasBeanService {
    @GET(UrlConfig.Path.HOME_URL)
    Call<AtlasBean> getHome(@QueryMap() HashMap<String, String> params);
}
