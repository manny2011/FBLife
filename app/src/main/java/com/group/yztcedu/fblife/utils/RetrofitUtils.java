package com.group.yztcedu.fblife.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group.yztcedu.fblife.main.search.Service.ICommonService;
import com.group.yztcedu.fblife.main.search.URL.UrlString;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Polaris on 2016/8/5.
 */
public class RetrofitUtils {
    private static RetrofitUtils instance=null;
    public Retrofit retrofit;
    public Gson gson;


    private RetrofitUtils(){}
    public static synchronized RetrofitUtils getInstance(){
        if (instance==null){
            instance = new RetrofitUtils();
        }
        return  instance;
    }
    public ICommonService getICommonService(){

        return getRetrofit().create(ICommonService.class);
    }
    public Retrofit getRetrofit( ){
        if (retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(UrlString.Path.SEARCH_BASE)
                    .addConverterFactory(GsonConverterFactory.create(createGson()))
                    .build();
        }
        return retrofit;
    }

    private Gson createGson(){

        return new GsonBuilder()
                .serializeNulls()
                .create();
    }

}
