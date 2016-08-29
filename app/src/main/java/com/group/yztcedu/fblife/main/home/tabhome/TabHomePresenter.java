package com.group.yztcedu.fblife.main.home.tabhome;

import com.group.yztcedu.fblife.main.home.bean.HomeBean;
import com.group.yztcedu.fblife.main.home.tabhome.homehttputils.HttpUtils;

import java.util.HashMap;

public class TabHomePresenter implements TabHomeContract.Presenter {
    private TabHomeContract.View view;
    private TabHomeContract.Model model;
    public TabHomePresenter(TabHomeContract.View view,TabHomeContract.Model model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void initData(HashMap<String, String> params) {
        model.getHomeDatainfo(params,new HttpUtils.HttpCallBack<HomeBean>(){

            @Override
            public void onSuccess(HomeBean homeBean) {
                view.onSuccessGetHomeDatainfo(homeBean.getDatainfo());
            }

            @Override
            public void onFail() {
                view.onFailGetHomeDatainfo("网络连接错误");
            }
        });
    }
}
