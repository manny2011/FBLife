package com.group.yztcedu.fblife.main.home.tabhome;

import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.home.bean.HomeBean;
import com.group.yztcedu.fblife.main.home.bean.HomeDatainfoBean;
import com.group.yztcedu.fblife.main.home.tabhome.homehttputils.HttpUtils;

import java.util.HashMap;
import java.util.List;

public class TabHomeContract {
    public interface View extends IBaseView {
        void onSuccessGetHomeDatainfo(List<HomeDatainfoBean> homeDatainfoBeen);
        void onFailGetHomeDatainfo(String msg);
    }

    public interface Model extends IBaseModel {
        void getHomeDatainfo(HashMap<String,String> params,HttpUtils.HttpCallBack<HomeBean> callBack);
    }

    public interface Presenter extends IBasePresenter {
        void initData(HashMap<String,String> params);
    }
}
