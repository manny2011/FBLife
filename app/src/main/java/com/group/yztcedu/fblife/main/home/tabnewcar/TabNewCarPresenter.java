package com.group.yztcedu.fblife.main.home.tabnewcar;


import com.group.yztcedu.fblife.main.home.bean.NewCarBean;
import com.group.yztcedu.fblife.main.home.tabnewcar.newcarhttputils.HttpUtils;

import java.util.HashMap;

public class TabNewCarPresenter implements TabNewCarContract.Presenter {
    private TabNewCarContract.View view;
    private TabNewCarContract.Modle modle;

    public TabNewCarPresenter(TabNewCarContract.View view, TabNewCarContract.Modle modle) {
        this.view = view;
        this.modle = modle;
    }

    @Override
    public void initData(HashMap<String, String> params) {
        modle.getNewCarInfo(params, new HttpUtils.HttpCallBack<NewCarBean>() {
            @Override
            public void onSuccess(NewCarBean newCarBean) {
                view.onSuccessGetNewCarinfo(newCarBean.getDatainfo());
            }
            @Override
            public void onFail() {
            view.onFailGetNewCarinfo("网络连接失败");
            }
        });
    }

}