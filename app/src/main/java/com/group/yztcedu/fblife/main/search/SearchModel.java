package com.group.yztcedu.fblife.main.search;


import com.group.yztcedu.fblife.main.search.Service.ICommonService;
import com.group.yztcedu.fblife.main.search.bean.SearchBean;
import com.group.yztcedu.fblife.main.search.bean.SearchUserBean;
import com.group.yztcedu.fblife.utils.RetrofitUtils;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by Polaris on 2016/8/5.
 */
public class SearchModel implements SearchContract.Model {


    @Override
    public void getSearchData(HashMap<String, String> params, Callback<SearchBean> callback) {
        ICommonService iCommonService = RetrofitUtils.getInstance().getICommonService();
        iCommonService.getSearch(params).enqueue(callback);
    }

    @Override
    public void getSearchUserData(HashMap<String, String> params, Callback<SearchUserBean> callback) {
        ICommonService iCommonService = RetrofitUtils.getInstance().getICommonService();
        iCommonService.getUserSearch(params).enqueue(callback);

    }
}
