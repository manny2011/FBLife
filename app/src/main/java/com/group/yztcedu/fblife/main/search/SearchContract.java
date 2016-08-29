package com.group.yztcedu.fblife.main.search;


import com.group.yztcedu.fblife.base.IBaseModel;
import com.group.yztcedu.fblife.base.IBasePresenter;
import com.group.yztcedu.fblife.base.IBaseView;
import com.group.yztcedu.fblife.main.search.bean.SearchBean;
import com.group.yztcedu.fblife.main.search.bean.SearchUserBean;
import com.group.yztcedu.fblife.main.search.bean.Searchinfobean;

import java.util.HashMap;
import java.util.List;

import retrofit2.Callback;

/**
 * Created by Polaris on 2016/8/5.
 */
public class SearchContract {
    public interface View extends IBaseView {
        public void onSuccessGetInformation(List<Searchinfobean> list);
        public void onFailGetInforamtion(String msg);
    }

    public interface Model extends IBaseModel {
        public void getSearchData(HashMap<String,String> params, Callback<SearchBean> callback);
        public void getSearchUserData(HashMap<String,String> params, Callback<SearchUserBean> callback);
    }

    public interface Presenter extends IBasePresenter {
        public void initSearchData(HashMap<String,String> params);
        public void initSearchUserData(HashMap<String,String> params);
    }
}
