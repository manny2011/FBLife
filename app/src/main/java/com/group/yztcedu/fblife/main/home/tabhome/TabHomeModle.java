package com.group.yztcedu.fblife.main.home.tabhome;


import com.group.yztcedu.fblife.main.home.bean.HomeBean;
import com.group.yztcedu.fblife.main.home.tabhome.homehttputils.HttpUtils;

import java.util.HashMap;

public class TabHomeModle implements TabHomeContract.Model {

    @Override
    public void getHomeDatainfo(HashMap<String, String> params, HttpUtils.HttpCallBack<HomeBean> callBack) {
        HttpUtils.getInstance().getHomeBeanData(params,callBack);
    }
}
