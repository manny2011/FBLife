package com.group.yztcedu.fblife.main.home.tabatlas;

import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.home.tabatlas.atlashttputils.HttpUtils;
import com.group.yztcedu.fblife.main.home.bean.AtlasBean;
import com.group.yztcedu.fblife.main.home.bean.AtlasInfoBean;

import java.util.HashMap;
import java.util.List;


public class TabAtlasContract {
    public interface View extends IBaseView{
        void onSuccessGetAtlasInfo(List<AtlasInfoBean> atlasInfoBeen);
        void onFailGetAtlasInfo(String msg);
    }
    public interface Modle extends IBaseModel{
        void getAtlas(HashMap<String,String> params, HttpUtils.HttpCallBack<AtlasBean> callBack);
    }
    public interface  Presenter extends IBasePresenter{
        void initData(HashMap<String,String> params);
    }
}
