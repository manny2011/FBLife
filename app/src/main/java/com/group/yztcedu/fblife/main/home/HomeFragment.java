package com.group.yztcedu.fblife.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseFragment;
import com.group.yztcedu.fblife.main.home.tabatlas.TabAtlasFragment;
import com.group.yztcedu.fblife.main.home.tabhome.TabHomeFragment;
import com.group.yztcedu.fblife.main.home.tabnewcar.TabNewCarFragment;
import com.group.yztcedu.fblife.main.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment {
    private String[] className = {"newcar", "guide", "drive","depreciate", "culture", "restyle", "tour", "news", "rv", "tieqi", "event","use", "sports"};

    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.home_tabLayout)
    TabLayout homeTabLayout;
    @BindView(R.id.home_viewPager)
    ViewPager homeViewPager;
    @BindView(R.id.home_fragment_plus_iv)
    ImageView homeFragmentPlusIv;
    private String[] tabTitles;
    List<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        homeToolbar.inflateMenu(R.menu.menu);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabTitles = getTabTitles();
        fragments = new ArrayList<>();
        fragments.add(new TabHomeFragment());
        for(int i=0;i<3;i++){
            fragments.add(TabNewCarFragment.newInstance(className[i]));
        }
        fragments.add(new TabAtlasFragment());
        for(int x= 0;x<10;x++){
            fragments.add(TabNewCarFragment.newInstance(className[x+3]));
        }

        TabLayoutAdapter adapter = new TabLayoutAdapter(getActivity().getSupportFragmentManager(), fragments, tabTitles);
        homeViewPager.setAdapter(adapter);
         homeViewPager.setCurrentItem(0);
        homeTabLayout.setupWithViewPager(homeViewPager);
        initDownPlus();

    }

    private void initDownPlus() {
        homeFragmentPlusIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HomeTabLayoutDetailsActivity.class));
            }
        });
    }

    private void initView() {
        homeToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    private String[] getTabTitles() {
        return new String[]{"首页", "新车", "导购", "试驾", "图集", "降价", "文化", "改装", "旅游", "行业", "房车", "铁骑", "活动","用车", "赛事"};
    }
}
