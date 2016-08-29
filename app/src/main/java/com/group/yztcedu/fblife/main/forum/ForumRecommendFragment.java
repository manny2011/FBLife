package com.group.yztcedu.fblife.main.forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseFragment;
import com.group.yztcedu.fblife.config.UrlConfig_Forum;
import com.group.yztcedu.fblife.main.forum.entity.App;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class ForumRecommendFragment extends BaseFragment implements ForumContract.View {

    ForumContract.Presenter presenter;
    PullToRefreshListView recommendRefreshListview;
    RecommendAdapter adapter;
    List<App> mList;
    HashMap<String,String> params ;
    int page=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_recommend_layout, null);
        presenter = new ForumPresenter(this);
        mList = new ArrayList<>();
        adapter = new RecommendAdapter(getContext(),R.layout.forum_recommend_item_layout,mList);
        recommendRefreshListview = (PullToRefreshListView) view.findViewById(R.id.forum_recommend_refreshListView);
        if(recommendRefreshListview==null){
            Log.i("TAG","refresh==null");
        }
        recommendRefreshListview.setMode(PullToRefreshBase.Mode.BOTH);
        recommendRefreshListview.setPullToRefreshOverScrollEnabled(false);
        recommendRefreshListview.setOnPullEventListener(new PullToRefreshBase.OnPullEventListener<ListView>() {
            @Override
            public void onPullEvent(PullToRefreshBase<ListView> refreshView, PullToRefreshBase.State state, PullToRefreshBase.Mode direction) {
                if(state.equals(PullToRefreshBase.State.PULL_TO_REFRESH)){
                    ILoadingLayout loadingLayoutProxy = refreshView.getLoadingLayoutProxy();
                    loadingLayoutProxy.setRefreshingLabel("刷新中");
                    loadingLayoutProxy.setReleaseLabel("刷新完成");
                    String time = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME);
                    loadingLayoutProxy.setLastUpdatedLabel(time);
                }
            }
        });
        recommendRefreshListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                initParams(page);
                presenter.getData(params);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                initParams(page);
                presenter.getData(params);


            }
        });
        ListView listView = recommendRefreshListview.getRefreshableView();
        listView.setAdapter(adapter);
        View headerView = LayoutInflater.from(getContext()).inflate(R.layout.forum_recommend_headview,null);
        listView.addHeaderView(headerView);
        initParams(page);
        presenter.getData(params);
        return view;
    }
    @Override
    public void onSuccess(List<App> list) {
        if(mList!=null&&page==1){
            mList.clear();
        }
        mList.addAll(list);
        adapter.notifyDataSetChanged();
        page++;
        recommendRefreshListview.onRefreshComplete();
    }

    @Override
    public void onFailed(String s) {
        Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
    }
    public void initParams(int page){
        params = new HashMap<>();
        params.put(UrlConfig_Forum.Key.A, UrlConfig_Forum.Value.A);
        params.put(UrlConfig_Forum.Key.C, UrlConfig_Forum.Value.C);
        params.put(UrlConfig_Forum.Key.DATATYPE, UrlConfig_Forum.Value.DATATYPE);
        params.put(UrlConfig_Forum.Key.PAGE,String.valueOf(page));
        params.put(UrlConfig_Forum.Key.PAGESIZE, UrlConfig_Forum.Value.PAGESIZE);
        params.put(UrlConfig_Forum.Key.TYPE,UrlConfig_Forum.Value.TYPE);
    }
}
