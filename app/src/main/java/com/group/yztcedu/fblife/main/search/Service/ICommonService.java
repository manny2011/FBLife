package com.group.yztcedu.fblife.main.search.Service;


import com.group.yztcedu.fblife.main.search.URL.UrlString;
import com.group.yztcedu.fblife.main.search.bean.SearchBean;
import com.group.yztcedu.fblife.main.search.bean.SearchUserBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Polaris on 2016/8/5.
 */
public interface ICommonService {

    @GET(UrlString.Path.SEARCH_INFORMATION)
    Call<SearchBean> getSearch(@QueryMap() HashMap<String,String> params);
    @GET(UrlString.Path.SEARCH_USER)
    Call<SearchUserBean> getUserSearch(@QueryMap() HashMap<String,String> params);
}
