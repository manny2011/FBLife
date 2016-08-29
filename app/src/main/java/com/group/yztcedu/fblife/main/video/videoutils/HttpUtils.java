package com.group.yztcedu.fblife.main.video.videoutils;

import android.util.Log;

import com.group.yztcedu.fblife.main.home.bean.VideoBean;
import com.group.yztcedu.fblife.main.home.bean.VideoInfoBean;

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
    public void getVideoBeanData(HashMap<String,String> params,final HttpCallBack<VideoBean> beanHttpCallBack){
        Call<VideoBean> videoBeanCall = RetrofitHelper
                .getInstance()
                .createRetrofitService(VideoBeanService.class)
                .getHome(params);
        videoBeanCall.enqueue(new Callback<VideoBean>() {
            @Override
            public void onResponse(Call<VideoBean> call, Response<VideoBean> response) {
                VideoBean bean = response.body();
                for (VideoInfoBean videoInfoBean : bean.getDatainfo()) {
                    Log.d("-----", "" + videoInfoBean.getTitle());
                }
                beanHttpCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<VideoBean> call, Throwable t) {
                beanHttpCallBack.onFail();
            }
        });
    }


}

