package com.group.yztcedu.fblife.main.forum;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/4.
 */
public class HttpHelper {
    private static HttpHelper httpHelper;
    private Retrofit retrofit;
    private IRetrofitService service;
    public static String base_url;
    private HttpHelper(String base_url){
        Gson gson = new GsonBuilder().serializeNulls().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(IRetrofitService.class);
    }
    /**单例模式,只能有一个人可以进来,???? 是不是这个原因?*/
    public static synchronized HttpHelper singleInstance(String base_url){
        /**这里面可能会出错*/

        if(httpHelper==null){
            httpHelper = new HttpHelper(base_url);
            Log.i("TAG","httpHelper is null");
        }
        return httpHelper;
    }
    public IRetrofitService getService(){
        return service;
    }
/****************锁的特性没有理解透彻*******************/
    /************为什么httpHelper在第二次用的时候已经不为空了呢??? **********/

}
