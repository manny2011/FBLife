package com.group.yztcedu.fblife.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseActivity;
import com.group.yztcedu.fblife.main.carbarn.GarageFragment;
import com.group.yztcedu.fblife.main.forum.ForumFragment;
import com.group.yztcedu.fblife.main.home.HomeFragment;
import com.group.yztcedu.fblife.main.store.StoreFragment;
import com.group.yztcedu.fblife.main.video.VideoFragment;
import com.group.yztcedu.fblife.widget.MyRadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    @BindView(R.id.btn_home)
    MyRadioButton btnHome;
    @BindView(R.id.btn_forum)
    MyRadioButton btnForum;
    @BindView(R.id.btn_carbarn)
    MyRadioButton btnCarbarn;
    @BindView(R.id.btn_video)
    MyRadioButton btnVideo;
    @BindView(R.id.btn_store)
    MyRadioButton btnStore;
    @BindView(R.id.rg_dh)
    RadioGroup rgDh;
    private HomeFragment homeFragment;
    private ForumFragment forumFragment;
    private GarageFragment garageFragment;
    private VideoFragment videoFragment;
    private StoreFragment storeFragment;
    public static final int SELECTED_HOME = 0;
    public static final int SELECTED_FORUM = 1;
    public static final int SELECTED_CARBARN = 2;
    public static final int SELECTED_VIDEO = 3;
    public static final int SELECTED_STORE = 4;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        selectFragment(SELECTED_HOME);
    }

    private void selectFragment(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
      transaction.hide(homeFragment).hide(forumFragment).hide(garageFragment).hide(videoFragment).hide(storeFragment);
        switch (position) {
            case SELECTED_HOME:
                transaction.show(homeFragment);
                break;
            case SELECTED_FORUM:
                transaction.show(forumFragment);
                break;
            case SELECTED_CARBARN:
                transaction.show(garageFragment);
                break;
            case SELECTED_VIDEO:
                transaction.show(videoFragment);
                break;
            case SELECTED_STORE:
                transaction.show(storeFragment);
                break;
        }
        transaction.commit();

    }


    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        forumFragment = new ForumFragment();
        garageFragment = new GarageFragment();
        videoFragment = new VideoFragment();
        storeFragment = new StoreFragment();
        transaction.add(R.id.frame_container, homeFragment);
        transaction.add(R.id.frame_container, forumFragment);
        transaction.add(R.id.frame_container, garageFragment);
        transaction.add(R.id.frame_container, videoFragment);
        transaction.add(R.id.frame_container, storeFragment);
        transaction.commit();

    }


    @OnClick({R.id.btn_home, R.id.btn_forum, R.id.btn_carbarn, R.id.btn_video, R.id.btn_store})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
            selectFragment(SELECTED_HOME);
                JCVideoPlayer.releaseAllVideos();
                break;
            case R.id.btn_forum:
                selectFragment(SELECTED_FORUM);
                JCVideoPlayer.releaseAllVideos();
                break;
            case R.id.btn_carbarn:
                selectFragment(SELECTED_CARBARN);
                JCVideoPlayer.releaseAllVideos();
                break;
            case R.id.btn_video:
                selectFragment(SELECTED_VIDEO);
                break;
            case R.id.btn_store:
                selectFragment(SELECTED_STORE);
                JCVideoPlayer.releaseAllVideos();
                break;
        }
    }


}
