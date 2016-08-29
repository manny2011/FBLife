package com.group.yztcedu.fblife.main.home.tabatlas;

import com.group.yztcedu.fblife.main.home.tabatlas.atlashttputils.HttpUtils;
import com.group.yztcedu.fblife.main.home.bean.AtlasBean;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/5.
 */
public class TabAtlasModle implements TabAtlasContract.Modle {
    @Override
    public void getAtlas(HashMap<String, String> params, HttpUtils.HttpCallBack<AtlasBean> callBack) {
        HttpUtils.getInstance().getAtlasBeanData(params,callBack);
    }
}
