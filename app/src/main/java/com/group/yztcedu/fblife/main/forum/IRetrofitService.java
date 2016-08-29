package com.group.yztcedu.fblife.main.forum;

import com.group.yztcedu.fblife.config.UrlConfig_Forum;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;
import com.group.yztcedu.fblife.main.forum.entity.PlatesBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/4.
 */
public interface IRetrofitService {

    @GET(UrlConfig_Forum.Path.relative_url)
    Call<NewsBean> getListApp(@QueryMap()
                               HashMap<String,String> params);
    /***********************分隔符************************/
    @GET(UrlConfig_Forum.DistrictPath.RELATIVE_URL)
    Call<PlatesBean> getPlateBean(@QueryMap()
                                  HashMap<String,String> params);

}
