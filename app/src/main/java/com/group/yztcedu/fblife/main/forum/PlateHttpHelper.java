package com.group.yztcedu.fblife.main.forum;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group.yztcedu.fblife.config.UrlConfig_Forum;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/8/6.
 */
public class PlateHttpHelper {
    /** 单例模式中的static 的用处?????*/
    private static PlateHttpHelper plateHttpHelper;
    private IRetrofitService service;
    private Retrofit retrofit;
    private PlateHttpHelper (){
        Gson gson = new GsonBuilder().serializeNulls().create();
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(UrlConfig_Forum.DistrictPath.BASE_URL)
                .build();
        service=retrofit.create(IRetrofitService.class);

    }


    public static PlateHttpHelper singleInstance(){
        if(plateHttpHelper==null){
            plateHttpHelper = new PlateHttpHelper();
        }
        return plateHttpHelper;
    }
    public IRetrofitService getService(){
        return service;
    }


}
