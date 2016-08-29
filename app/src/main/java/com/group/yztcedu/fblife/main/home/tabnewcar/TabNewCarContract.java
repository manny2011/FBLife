package com.group.yztcedu.fblife.main.home.tabnewcar;


import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.home.bean.NewCarBean;
import com.group.yztcedu.fblife.main.home.bean.NewCarInfoBean;
import com.group.yztcedu.fblife.main.home.tabnewcar.newcarhttputils.HttpUtils;

import java.util.HashMap;
import java.util.List;

public class TabNewCarContract {
    public interface View extends IBaseView{
         void onSuccessGetNewCarinfo(List<NewCarInfoBean> newCarInfoBeen);
         void onFailGetNewCarinfo(String msg);

    }
    public interface Modle extends IBaseModel{
         void getNewCarInfo(HashMap<String,String> params,HttpUtils.HttpCallBack<NewCarBean> callBack);
    }
    public interface Presenter extends IBasePresenter{
         void initData(HashMap<String,String> params);
    }
}
