package com.group.yztcedu.fblife.main.home.tabhome.homehttputils;

import android.content.Context;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpUtil {

    private static OkHttpClient okHttpClient;
    private static   OkHttpUtil okHttpUtil;

    //实现okhttpclient单例模式

    private  static OkHttpClient  getOkHttpClientInstense(){
        if (okHttpClient==null){
            okHttpClient=new OkHttpClient();
        }
            return okHttpClient;

    }


    //私有化构造器
    private OkHttpUtil (Context context){
        okHttpClient=getOkHttpClientInstense();
    }

    /**
     * @param context
     * @return
     *
     * 单例模式
     */
    public  static OkHttpUtil  getOkHttpUtilInstanse(Context context){
        if(okHttpUtil==null){
            okHttpUtil=new OkHttpUtil(context);
        }
        return okHttpUtil;
    }

    /**
     * @param path
     * @return request;
     */
    private Request getRequset(String path){
        Request.Builder builder=new Request.Builder();
            builder.url(path);

        return builder.build();

    }
    private Response getResponse(String path) throws IOException {
          Request request=getRequset(path);
        return  okHttpClient.newCall(request).execute();
    }
    private ResponseBody getResponseBody(String path) throws IOException {
        Response response=getResponse(path);
        return  response.body();
    }

    /**
     * @param context
     * @param path
     * @return
     * @throws IOException
     *
     * 获取网络请求字符串
     */
    public static String  getStr(Context context,String path) throws IOException {
        ResponseBody responseBody=getOkHttpUtilInstanse(context).getResponseBody(path);
        return  responseBody.string();
    }

    /**
     * @param context
     * @param path
     * @param callback
     *
     * 异步请求
     */
    public  static  void  getDataByAsyn(Context context, String path, Callback callback){

        Request request =getOkHttpUtilInstanse(context).getRequset(path);
        okHttpClient.newCall(request).enqueue(callback);
    }










}
