package com.group.yztcedu.fblife.main.forum;

import com.group.yztcedu.fblife.main.forum.entity.App;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/2.
 */
public class MainPresenter implements MainContract.Presenter {
    MainContract.Model model;
    MainContract.View view;
    public MainPresenter(MainContract.View view){
        this.view=view;
        this.model = new MainModel();
    }

    @Override
    public void getData(HashMap<String, String> params) {
        model.getData(params, new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                List<App> list = response.body().getApp();
                view.onSuccess(list);

            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                view.onFailed(t.toString());

            }
        });
    }
}
