package com.group.yztcedu.fblife.main.forum;

import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.forum.entity.App;
import com.group.yztcedu.fblife.main.forum.entity.NewsBean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

public class MainContract {
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
}
