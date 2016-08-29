package com.group.yztcedu.fblife.main.carbarn;

import com.group.yztcedu.fblife.main.carbarn.entity.VehicleModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2016/8/11.
 */
public interface IGarageRetrofitService {

    @GET("carapi/getserieslist.php")
    Call<VehicleModel> getVehicleModel(@QueryMap
                                       HashMap<String,String> params);
}
