package com.group.yztcedu.fblife.main.forum;

import com.group.yztcedu.fblife.config.UrlConfig_Forum;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MainModel implements MainContract.Model {

    @Override
    public void getData(HashMap<String, String> params, Callback<NewsBean> callback) {
        HttpHelper.singleInstance(UrlConfig_Forum.Path.base_url).getService().getListApp(params).enqueue(callback);
    }
}
