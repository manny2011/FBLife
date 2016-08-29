package com.group.yztcedu.fblife.main.home.tabatlas.atlashttputils;

import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.tabnewcar.bean.NewCarBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/4.
 */
public interface NewCarBeanService {
    @GET(UrlConfig.Path.HOME_URL)
    Call<NewCarBean> getHome(@QueryMap() HashMap<String, String> params);
}
