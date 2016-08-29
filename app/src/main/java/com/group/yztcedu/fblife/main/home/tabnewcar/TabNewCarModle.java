package com.group.yztcedu.fblife.main.home.tabnewcar;


import com.group.yztcedu.fblife.main.home.bean.NewCarBean;
import com.group.yztcedu.fblife.main.home.tabnewcar.newcarhttputils.HttpUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/5.
 */
public class TabNewCarModle implements TabNewCarContract.Modle {


    @Override
    public void getNewCarInfo(HashMap<String, String> params, HttpUtils.HttpCallBack<NewCarBean> callBack) {
        HttpUtils.getInstance().getNewCarBeanData(params,callBack);
    }
}
