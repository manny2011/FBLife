package com.group.yztcedu.fblife.main.carbarn;

import com.group.yztcedu.fblife.main.carbarn.entity.VehicleModel;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/11.
 */
public interface GarageContract {

    public interface View{
        void onSuccess(VehicleModel model);
        void onFailed(String s);
    }
    public interface Presenter{
        void getData(HashMap<String,String> params);
    }
    interface Model{
        void getData(HashMap<String,String> params,Callback<VehicleModel> callback);
    }

}
