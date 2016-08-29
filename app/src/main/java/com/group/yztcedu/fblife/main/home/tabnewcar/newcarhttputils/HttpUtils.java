package com.group.yztcedu.fblife.main.home.tabnewcar.newcarhttputils;

import android.util.Log;

import com.group.yztcedu.fblife.main.home.bean.NewCarBean;
import com.group.yztcedu.fblife.main.home.bean.NewCarInfoBean;

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
    public void getNewCarBeanData(HashMap<String,String> params,final HttpCallBack<NewCarBean> beanHttpCallBack){
        Call<NewCarBean> newCarBeanCall = RetrofitHelper
                .getInstance()
                .createRetrofitService(NewCarBeanService.class)
                .getHome(params);
        newCarBeanCall.enqueue(new Callback<NewCarBean>() {
            @Override
            public void onResponse(Call<NewCarBean> call, Response<NewCarBean> response) {
                NewCarBean bean = response.body();
                for (NewCarInfoBean newCarInfoBean : bean.getDatainfo()) {
                    Log.d("-----", "" + newCarInfoBean.getPhoto());
                }
                beanHttpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<NewCarBean> call, Throwable t) {
                beanHttpCallBack.onFail();
            }
        });
    }


}

