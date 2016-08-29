package com.group.yztcedu.fblife.main.forum;

import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;
import com.group.yztcedu.fblife.main.forum.entity.PlatesBean;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ForumModel implements ForumContract.Model ,ForumContract.Model1{

    @Override
    public void getData(HashMap<String, String> params, Callback<NewsBean> callback) {
        HttpHelper.singleInstance(UrlConfig.Path.BASE_URL).getService().getListApp(params).enqueue(callback);
    }

    @Override
    public void getPlateBean(HashMap<String, String> params, Callback<PlatesBean> callback) {
        PlateHttpHelper.singleInstance().getService().getPlateBean(params).enqueue(callback);

    }
}
