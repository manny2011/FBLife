package com.group.yztcedu.fblife.main.home.tabatlas.atlashttputils;

import android.util.Log;

import com.group.yztcedu.fblife.main.home.bean.AtlasBean;
import com.group.yztcedu.fblife.main.home.bean.AtlasInfoBean;

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
    public void getAtlasBeanData(HashMap<String,String> params,final HttpCallBack<AtlasBean> beanHttpCallBack){
        Call<AtlasBean> atlasBeanCall = RetrofitHelper
                .getInstance()
                .createRetrofitService(AtlasBeanService.class)
                .getHome(params);
        atlasBeanCall.enqueue(new Callback<AtlasBean>() {
            @Override
            public void onResponse(Call<AtlasBean> call, Response<AtlasBean> response) {
                AtlasBean bean = response.body();
                for (AtlasInfoBean atlasInfoBean : bean.getDatainfo()) {
                    Log.d("-----", "" + atlasInfoBean.getTitle());
                }
                beanHttpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<AtlasBean> call, Throwable t) {
                beanHttpCallBack.onFail();
            }
        });
    }


}

