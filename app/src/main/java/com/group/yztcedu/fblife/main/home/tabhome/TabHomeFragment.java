package com.group.yztcedu.fblife.main.home.tabhome;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseFragment;
import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.bean.HomeDatainfoBean;
import com.group.yztcedu.fblife.main.home.bean.HomeViewPagerBean;
import com.group.yztcedu.fblife.main.home.bean.HomeViewPagerNewsBean;
import com.group.yztcedu.fblife.main.home.tabhome.homehttputils.OkHttpUtil;
import com.group.yztcedu.fblife.main.homedetails.HomeDetailsActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabHomeFragment extends BaseFragment implements TabHomeContract.View {
    @BindView(R.id.tab_home_lv)
    PullToRefreshListView pListView;
    private ViewPager homeHomeViewPager;
    private LinearLayout headerContainer;
    private TextView headerTitle;
    private ListView mListView;
    private HomeAdapter homeAdapter;
    private List<HomeDatainfoBean> mList;
    private TabHomeContract.Presenter presenter;
    private TabHomeContract.Model model;

    private Handler handler = new Handler();
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                final HomeViewPagerBean homeViewPagerBean = (HomeViewPagerBean) msg.obj;
                news = homeViewPagerBean.getNews();
                MyAdapter viewPagerAdapter = new MyAdapter(news);
                homeHomeViewPager.setAdapter(viewPagerAdapter);
                for (int i = 0; i < news.size(); i++) {
                    View points = new View(getContext());
                    points.setBackgroundResource(R.mipmap.dot_enable);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25, 25);
                    params.leftMargin = 2;
                    points.setLayoutParams(params);
                    headerContainer.addView(points);
                }
                //初始化标题
                headerTitle.setText(news.get(0).getTitle());
                //初始化小圆点
                headerContainer.getChildAt(0).setBackgroundResource(R.mipmap.dot_normal);
                homeHomeViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        headerTitle.setText(news.get(position).getTitle());
                        //小圆点变化
                        for (int i = 0; i < headerContainer.getChildCount(); i++) {
                            headerContainer.getChildAt(i).setBackgroundResource(R.mipmap.dot_enable);
                            if (i == position) {
                                headerContainer.getChildAt(position).setBackgroundResource(R.mipmap.dot_normal);
                            }
                        }
                    }
                });
                mListView.addHeaderView(headerView);

            }

        }
    };
    private List<HomeViewPagerNewsBean> news;
    private View headerView;
    private int page = 1;
    public TabHomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        ButterKnife.bind(this, view);
        pListView.setMode(PullToRefreshBase.Mode.BOTH);
        pListView.setPullToRefreshOverScrollEnabled(true);
        mListView = pListView.getRefreshableView();
        getHomeViewPagerPath();

        initView();
        initAddHeaderView();
        model = new TabHomeModle();
        presenter = new TabHomePresenter(this, model);
        presenter.initData(initParams(page));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                // 下拉刷新
                pListView.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                pListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                pListView.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
                presenter.initData(initParams(++page));

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                pListView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                pListView.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                pListView.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后加载时间:" + str);

                presenter.initData(initParams(++page));
            }
        });
    }


    private void initAddHeaderView() {
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.tab_home_header_view, null);
        homeHomeViewPager = (ViewPager) headerView.findViewById(R.id.home_home_viewPager);
        headerTitle = (TextView) headerView.findViewById(R.id.header_tvTitle);
        headerContainer = (LinearLayout) headerView.findViewById(R.id.header_container);
    }

    private void initView() {
        mList = new ArrayList<>();
        homeAdapter = new HomeAdapter(mList);
        mListView.setAdapter(homeAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        params.put(UrlConfig.Key.CLASSNAME, "");
        params.put(UrlConfig.Key.PAGESIZE, "10");
        params.put(UrlConfig.Key.PAGE, "" + page);
        params.put(UrlConfig.Key.DEBUG, "1");
        return params;
    }

    @Override
    public void onSuccessGetHomeDatainfo(final List<HomeDatainfoBean> homeDatainfoBeen) {
        handler.post(new Runnable() {
            @Override
            public void run() {

                mList.addAll(homeDatainfoBeen);
                homeAdapter.notifyDataSetChanged();
                pListView.onRefreshComplete();
            }
        });
    }


    @Override
    public void onFailGetHomeDatainfo(String msg) {
        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    public void getHomeViewPagerPath() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str = OkHttpUtil.getStr(getActivity(), UrlConfig.HOMEPAGE_VIEWPAGER_URL);
                    Gson gson = new GsonBuilder().create();
                    HomeViewPagerBean homeViewPagerBean = gson.fromJson(str, HomeViewPagerBean.class);
                    Message msg = Message.obtain();
                    msg.what = 1;
                    msg.obj = homeViewPagerBean;
                    mHandler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
