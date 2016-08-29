package com.group.yztcedu.fblife.main.forum;

import android.util.Log;

import com.group.yztcedu.fblife.main.forum.entity.App;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;
import com.group.yztcedu.fblife.main.forum.entity.PlatesBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ForumPresenter implements ForumContract.Presenter,ForumContract.Presenter1 {
    /*************************************************************/
    ForumContract.Model model;
    ForumContract.View view;
    public ForumPresenter(ForumContract.View view){
        this.view=view;
        this.model = new ForumModel();
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

    /********************************************************************/

    ForumContract.View1 view1;
    ForumContract.Model1 model1;
    public ForumPresenter(ForumContract.View1 view1){
        this.view1=view1;
        this.model1=new ForumModel();
    }
    @Override
    public void getPlateBean(HashMap<String, String> params) {
        model1.getPlateBean(params, new Callback<PlatesBean>() {
            @Override
            public void onResponse(Call<PlatesBean> call, Response<PlatesBean> response) {
                if(response.body()==null){
                    Log.i("TAG","responsebody is null" );
                }
                view1.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<PlatesBean> call, Throwable t) {
                view1.onFailed(t.toString());
            }
        });

    }






}
