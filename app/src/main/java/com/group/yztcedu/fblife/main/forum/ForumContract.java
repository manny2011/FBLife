package com.group.yztcedu.fblife.main.forum;

import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.forum.entity.App;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;
import com.group.yztcedu.fblife.main.forum.entity.PlatesBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

public class ForumContract {

    public interface View extends IBaseView{
        void onSuccess(List<App> list);
        void onFailed(String s);

    }
    public interface Model extends IBaseModel{
        void getData(HashMap<String, String> params, Callback<NewsBean> callback);
    }

    public interface Presenter extends IBasePresenter{
        void getData(HashMap<String, String> params);
    }
    /**问题就在这:要重复定义多个接口(为不同的数据类型),要学会使用泛型,*/
    public interface View1 extends IBaseView{

        void onSuccess(PlatesBean platesBean);
        void onFailed(String s);

    }
    public interface Model1 extends IBaseModel{

        void getPlateBean(HashMap<String, String> params, Callback<PlatesBean> callback);
    }

    public interface Presenter1 extends IBasePresenter{
        /**可以复用这个接口中的方法*/

        void getPlateBean(HashMap<String, String> params);
    }
}
