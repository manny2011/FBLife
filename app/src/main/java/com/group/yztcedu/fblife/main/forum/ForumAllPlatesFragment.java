package com.group.yztcedu.fblife.main.forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.group.yztcedu.fblife.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/8/4.
 * 存在问题:viewpager中的4个fragment切换到第三个时候,前面的fragment已经被销毁,这是为什么?
 *
 */
public class ForumAllPlatesFragment extends Fragment {

    @BindView(R.id.forum_tab_district_image)
    ImageView forumTabDistrictImage;
    @BindView(R.id.forum_tab_district)
    RelativeLayout forumTabDistrict;
    @BindView(R.id.forum_tab_carstyle_image)
    ImageView forumTabCarstyleImage;
    @BindView(R.id.forum_tab_carstyle)
    RelativeLayout forumTabCarstyle;
    @BindView(R.id.forum_tab_theme_image)
    ImageView forumTabThemeImage;
    @BindView(R.id.forum_tab_theme)
    RelativeLayout forumTabTheme;
    @BindView(R.id.forum_tab_buy_image)
    ImageView forumTabBuyImage;
    @BindView(R.id.forum_tab_buy)
    RelativeLayout forumTabBuy;
    @BindView(R.id.forum_allplates_tab)
    LinearLayout forumAllplatesTab;
    @BindView(R.id.forum_viewpager)
    ViewPager forumViewpager;
    private static final int DISTRICT=0;
    private static final int CARSTYLE=1;
    private static final int THEME=2;
    private static final int BUY=3;
    List<Fragment> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_allplates_layout, null);
        ButterKnife.bind(this, view);
        initFragment();
        ForumPagerAdapter adapter = new ForumPagerAdapter(getChildFragmentManager(),list);
        forumViewpager.setAdapter(adapter);
        forumTabDistrictImage.setSelected(true);
        forumViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            /** 为viewpager设置滑动监听,不能在这个方法外面设置 */
            @Override
            public void onPageSelected(int position) {
                setButtonSelected();
                switch (position){
                    case DISTRICT:
                        forumTabDistrictImage.setSelected(true);
                        break;
                    case CARSTYLE:
                        forumTabCarstyleImage.setSelected(true);
                        break;
                    case THEME:
                        forumTabThemeImage.setSelected(true);
                        break;
                    case BUY:
                        forumTabBuyImage.setSelected(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void initFragment() {
        Bundle bundle1=new Bundle();
        bundle1.putString("category","diqu");
        Bundle bundle2=new Bundle();
        bundle2.putString("category","chexing");
        Bundle bundle3=new Bundle();
        bundle3.putString("category","zhuti");
        Bundle bundle4=new Bundle();
        bundle4.putString("category","jiaoyi");
        list=new ArrayList<>();
        ForumPagerDistrictFragment districtFragment = new ForumPagerDistrictFragment();
        districtFragment.setArguments(bundle1);
        ForumPagerDistrictFragment carstyleFragment = new ForumPagerDistrictFragment();
        carstyleFragment.setArguments(bundle2);
        ForumPagerDistrictFragment themeFragment = new ForumPagerDistrictFragment();
        themeFragment.setArguments(bundle3);
        ForumPagerDistrictFragment buyFragment = new ForumPagerDistrictFragment();
        buyFragment.setArguments(bundle4);
        list.add(districtFragment);
        list.add(carstyleFragment);
        list.add(themeFragment);
        list.add(buyFragment);
    }

    @OnClick({R.id.forum_tab_district, R.id.forum_tab_carstyle, R.id.forum_tab_theme, R.id.forum_tab_buy})
    public void onClick(View view) {
        setButtonSelected();
        switch (view.getId()) {
            case R.id.forum_tab_district:
                forumViewpager.setCurrentItem(DISTRICT);
                forumTabDistrictImage.setSelected(true);
                break;
            case R.id.forum_tab_carstyle:
                forumViewpager.setCurrentItem(CARSTYLE);
                forumTabCarstyleImage.setSelected(true);
                break;
            case R.id.forum_tab_theme:
                forumViewpager.setCurrentItem(THEME);
                forumTabThemeImage.setSelected(true);
                break;
            case R.id.forum_tab_buy:
                forumViewpager.setCurrentItem(BUY);
                forumTabBuyImage.setSelected(true);
                break;
        }
    }

    public void setButtonSelected(){
        forumTabDistrictImage.setSelected(false);
        forumTabCarstyleImage.setSelected(false);
        forumTabThemeImage.setSelected(false);
        forumTabBuyImage.setSelected(false);
    }

}
