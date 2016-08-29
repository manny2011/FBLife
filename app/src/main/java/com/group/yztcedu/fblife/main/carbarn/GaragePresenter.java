package com.group.yztcedu.fblife.main.carbarn;

import com.group.yztcedu.fblife.main.carbarn.entity.VehicleModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/8/11.
 */
public class GaragePresenter implements GarageContract.Presenter {
    GarageContract.View view;
    GarageContract.Model model;
    public GaragePresenter(GarageContract.View view){
        this.view=view;
        model=new GarageModel();
    }


    @Override
    public void getData(HashMap<String, String> params) {
        model.getData(params, new Callback<VehicleModel>() {
            @Override
            public void onResponse(Call<VehicleModel> call, Response<VehicleModel> response) {

                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<VehicleModel> call, Throwable t) {
                view.onFailed("no_use");
            }
        });

    }
}
