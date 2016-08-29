package com.group.yztcedu.fblife.main.home.tabhome.homehttputils;

import android.util.Log;

import com.group.yztcedu.fblife.main.home.bean.HomeBean;
import com.group.yztcedu.fblife.main.home.bean.HomeDatainfoBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpUtils {
    private static HttpUtils instance;
    private HttpUtils(){
    }
    public static synchronized HttpUtils getInstance(){
        if(instance==null){
            instance= new HttpUtils();
        }
        return instance;
    }
    public interface HttpCallBack<T>{
        public void onSuccess(T t);
        public void onFail();
    }
    public void getHomeBeanData(HashMap<String,String> params,final HttpCallBack<HomeBean> beanHttpCallBack){
        Call<HomeBean> homeBeanCall = RetrofitHelper
                .getInstance()
                .createRetrofitService(HomeBeanService.class)
                .getHome(params);
        homeBeanCall.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                HomeBean bean = response.body();
                for (HomeDatainfoBean homeDatainfoBean : bean.getDatainfo()) {
                    Log.d("-----", "" + homeDatainfoBean.getChannelName());
                }
                beanHttpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                beanHttpCallBack.onFail();
            }
        });
    }


}

