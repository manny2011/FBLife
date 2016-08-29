package com.group.yztcedu.fblife.main.video;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseFragment;
import com.group.yztcedu.fblife.config.UrlConfig;
import com.group.yztcedu.fblife.main.home.bean.VideoInfoBean;
import com.group.yztcedu.fblife.main.login.LoginActivity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment implements VideoContract.View {
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.video_pListView)
    PullToRefreshListView videoPListView;
    private VideoContract.Modle modle;
    private VideoContract.Presenter presenter;
    private List<VideoInfoBean> videoList;
    private int page = 1;
    private VideoAdapter adapter;

    public VideoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, null);
        ButterKnife.bind(this, view);

        videoPListView.setMode(PullToRefreshBase.Mode.BOTH);
        videoPListView.setPullToRefreshOverScrollEnabled(true);
        initView();
        modle = new VideoModle();
        presenter = new VideoPresenter(this,modle);
        presenter.initData(initParams(page++));
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoPListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                // 下拉刷新 业务代码
                videoPListView.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                videoPListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                videoPListView.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后更新时间:" + str);
                presenter.initData(initParams(page++));

            }


            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载的任务
                String str = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                videoPListView.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                videoPListView.getLoadingLayoutProxy().setPullLabel("上拉加载更多");
                videoPListView.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("最后加载时间:" + str);

                presenter.initData(initParams(page++));
            }
        });
    }

    private void initView() {
        videoList = new ArrayList<>();
        adapter = new VideoAdapter(videoList);
        videoPListView.setAdapter(adapter);
        homeToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

    }
    public HashMap<String,String> initParams(int page){
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.Key.C, "news");
        params.put(UrlConfig.Key.A, "getvideolist");
        params.put(UrlConfig.Key.PAGESIZE, "20");
        params.put(UrlConfig.Key.PAGE, ""+page++);
        return params;
    }

    @Override
    public void onSuccessGetVideoInfo(List<VideoInfoBean> videoInfoBeen) {
        videoList.addAll(videoInfoBeen);
        adapter.notifyDataSetChanged();
        videoPListView.onRefreshComplete();
    }

    @Override
    public void onFailGetVideoInfo(String mag) {
        Toast.makeText(getActivity(), mag, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
