package com.group.yztcedu.fblife.main.carbarn;

import com.group.yztcedu.fblife.main.carbarn.entity.VehicleModel;

import java.util.HashMap;

import retrofit2.Callback;

/**
 * Created by Administrator on 2016/8/11.
 */
public class GarageModel implements GarageContract.Model {
    @Override
    public void getData(HashMap<String, String> params, Callback<VehicleModel> callback) {
        HttpHelper.singleInstance().getService().getVehicleModel(params).enqueue(callback);
    }
}
