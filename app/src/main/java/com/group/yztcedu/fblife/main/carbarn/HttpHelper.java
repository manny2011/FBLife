package com.group.yztcedu.fblife.main.carbarn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/11.
 */
public class HttpHelper {

    private static HttpHelper httpHelper;
    IGarageRetrofitService service;
    Retrofit retrofit;
    private HttpHelper(){
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://carport.fblife.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service=retrofit.create(IGarageRetrofitService.class);
    }
    public static synchronized HttpHelper singleInstance(){
        if(httpHelper==null){
            httpHelper=new HttpHelper();
        }
        return httpHelper;
    }
    public IGarageRetrofitService getService(){
        return service;
    }


}
