package com.group.yztcedu.fblife.main.home.tabnewcar;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import com.group.yztcedu.fblife.main.home.bean.NewCarInfoBean;
import com.group.yztcedu.fblife.main.homedetails.HomeDetailsActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabNewCarFragment extends BaseFragment implements TabNewCarContract.View {
    @BindView(R.id.tab_home_lv)
    PullToRefreshListView tabHomeLv;
    private NewCarAdapter adapter;
    private int page =1;

    public static TabNewCarFragment newInstance(String msg) {
        TabNewCarFragment fragment = new TabNewCarFragment();
        Bundle args = new Bundle();
        //args.putInt("position", position);
        args.putString("msg", msg);
        fragment.setArguments(args);
        return fragment;
    }


    private String className;
    private TabNewCarContract.Modle modle;
    private TabNewCarContract.Presenter presenter;
    private List<NewCarInfoBean> mList;
    private Handler mHandler = new Handler();

    public TabNewCarFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        ButterKnife.bind(this, view);
        tabHomeLv.setMode(PullToRefreshBase.Mode.BOTH);
        tabHomeLv.setPullToRefreshOverScrollEnabled(true);
        initView();
        modle = new TabNewCarModle();
        presenter = new TabNewCarPresenter(this, modle);
        presenter.initData(initParams(page));
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
                presenter.initData(initParams(++page));
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                tabHomeLv.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                tabHomeLv.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                tabHomeLv.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后加载时间:" + str);

                presenter.initData(initParams(++page));
            }
        });
    }

    private void initView() {
        mList = new ArrayList<>();
        Bundle arguments = getArguments();
        className = arguments.getString("msg");
        adapter = new NewCarAdapter(mList);
        tabHomeLv.setAdapter(adapter);
        tabHomeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getContext(), HomeDetailsActivity.class));
            }
        });

    }

    public HashMap<String, String> initParams(int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.Key.C, "appnews");
        params.put(UrlConfig.Key.A, "getAppIndex");
        params.put(UrlConfig.Key.TYPE, "json");
        params.put(UrlConfig.Key.CLASSNAME, className);
        params.put(UrlConfig.Key.PAGESIZE, "20");
        params.put(UrlConfig.Key.PAGE, ""+page);
        return params;
    }

    @Override
    public void onSuccessGetNewCarinfo(final List<NewCarInfoBean> newCarInfoBeen) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mList.addAll(newCarInfoBeen);
                adapter.notifyDataSetChanged();
                tabHomeLv.onRefreshComplete();
            }
        });
    }

    @Override
    public void onFailGetNewCarinfo(String msg) {
        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();
    }
}
