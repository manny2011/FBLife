package com.group.yztcedu.fblife.main.search;


import android.util.Log;

import com.group.yztcedu.fblife.main.search.bean.SearchBean;
import com.group.yztcedu.fblife.main.search.bean.SearchUserBean;
import com.group.yztcedu.fblife.main.search.bean.Searchinfobean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Polaris on 2016/8/5.
 */
public class SearchPresenter implements SearchContract.Presenter {
    public SearchContract.Model model;
    public SearchContract.View view;

    public SearchPresenter(SearchContract.Model model,SearchContract.View view){
        this.model = model;
        this.view =view;
    }

    @Override
    public void initSearchData(HashMap<String, String> params) {
        model.getSearchData(params, new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {
                if(response.isSuccessful()){
                    Log.i("", "---onResponse: "+response.body());
                    SearchBean body = response.body();
                    List<Searchinfobean> list = body.getSearchinfo();
                    view.onSuccessGetInformation(list);
                }
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {
                view.onFailGetInforamtion("网络数据访问失败");
            }
        });
    }

    @Override
    public void initSearchUserData(HashMap<String, String> params) {
        model.getSearchUserData(params, new Callback<SearchUserBean>() {
            @Override
            public void onResponse(Call<SearchUserBean> call, Response<SearchUserBean> response) {
                if (response.isSuccessful()){
                    SearchUserBean body = response.body();
                }
            }

            @Override
            public void onFailure(Call<SearchUserBean> call, Throwable t) {

            }
        });
    }
}
