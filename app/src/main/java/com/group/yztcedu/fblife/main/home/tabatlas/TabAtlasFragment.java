package com.group.yztcedu.fblife.main.home.tabatlas;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseFragment;
import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.bean.AtlasInfoBean;
import com.group.yztcedu.fblife.main.homedetails.HomeDetailsActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAtlasFragment extends BaseFragment implements TabAtlasContract.View {
    @BindView(R.id.tab_home_lv)
    PullToRefreshListView tabHomeLv;
    private AtlasAdapter atlasAdapter;
    private List<AtlasInfoBean> atlasList;
    private TabAtlasContract.Presenter presenter;
    private TabAtlasContract.Modle modle;
    private Handler mHandler = new Handler();
    private int page = 1;


    public TabAtlasFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        ButterKnife.bind(this, view);
        tabHomeLv.setMode(PullToRefreshBase.Mode.BOTH);
        tabHomeLv.setPullToRefreshOverScrollEnabled(true);
        initView();
        modle = new TabAtlasModle();
        presenter = new TabAtlasPresenter(this, modle);
        presenter.initData(getParams(page));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabHomeLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                // 下拉刷新 业务代码
                tabHomeLv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                tabHomeLv.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                tabHomeLv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
                presenter.initData(getParams(++page));
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                tabHomeLv.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                tabHomeLv.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                tabHomeLv.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后加载时间:" + str);
                presenter.initData(getParams(++page));
            }
        });
    }

    private void initView() {
        atlasList = new ArrayList<>();
        atlasAdapter = new AtlasAdapter(atlasList);
        tabHomeLv.setAdapter(atlasAdapter);
        tabHomeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), HomeDetailsActivity.class));
            }
        });
    }

    public HashMap<String, String> getParams(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.Key.C, "appnews");
        params.put(UrlConfig.Key.A, "getAppIndex");
        params.put(UrlConfig.Key.TYPE, "json");
        params.put(UrlConfig.Key.CLASSNAME, "photo");
        params.put(UrlConfig.Key.PAGESIZE, "10");
        params.put(UrlConfig.Key.PAGE, ""+page);
        return params;
    }

    @Override
    public void onSuccessGetAtlasInfo(final List<AtlasInfoBean> atlasInfoBeen) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                atlasList.addAll(atlasInfoBeen);
                atlasAdapter.notifyDataSetChanged();
                tabHomeLv.onRefreshComplete();
            }
        });
    }

    @Override
    public void onFailGetAtlasInfo(String msg) {
        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();
    }
}
