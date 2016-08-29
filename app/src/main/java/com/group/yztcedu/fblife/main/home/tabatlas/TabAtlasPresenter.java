package com.group.yztcedu.fblife.main.home.tabatlas;

import com.group.yztcedu.fblife.main.home.tabatlas.atlashttputils.HttpUtils;
import com.group.yztcedu.fblife.main.home.bean.AtlasBean;

import java.util.HashMap;


public class TabAtlasPresenter implements TabAtlasContract.Presenter {
    private TabAtlasContract.Modle modle;
    private TabAtlasContract.View view;
    public TabAtlasPresenter(TabAtlasContract.View view,TabAtlasContract.Modle modle){
        this.view = view;
        this.modle = modle;
    }
    @Override
    public void initData(HashMap<String, String> params) {
        modle.getAtlas(params, new HttpUtils.HttpCallBack<AtlasBean>() {
            @Override
            public void onSuccess(AtlasBean atlasBean) {
                view.onSuccessGetAtlasInfo(atlasBean.getDatainfo());
            }

            @Override
            public void onFail() {
                view.onFailGetAtlasInfo("网络连接失败");
            }
        });
    }
}
