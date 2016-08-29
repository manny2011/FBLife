package com.group.yztcedu.fblife.main.forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ForumFragment extends Fragment {


    @BindView(R.id.forum_toolbar)
    Toolbar forumToolbar;
    @BindView(R.id.forum_radioButton_recommend)
    RadioButton forumRadioButtonRecommend;
    @BindView(R.id.forum_radioButton_allPlates)
    RadioButton forumRadioButtonAllPlates;
    @BindView(R.id.forum_radioGroup)
    RadioGroup forumRadioGroup;
    @BindView(R.id.forum_container)
    FrameLayout forumContainer;
    ForumRecommendFragment forumRecommendFragment;
    ForumAllPlatesFragment forumAllPlatesFragment;
    public static final int FORUM_RECOMMEND=1;
    public static final int FORUM_ALLPLATES=2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.forum_layout, null);
        ButterKnife.bind(this, view);
        forumToolbar.setNavigationIcon(R.mipmap.men);
        forumToolbar.inflateMenu(R.menu.menu);
        initFragment();
        selectFragment(FORUM_RECOMMEND);
        initView();
        return view;
    }

    private void initView() {
        forumToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    public void initFragment() {
        forumRecommendFragment = new ForumRecommendFragment();
        forumAllPlatesFragment = new ForumAllPlatesFragment();
        getChildFragmentManager().beginTransaction()
                .add(R.id.forum_container,forumRecommendFragment)
                .add(R.id.forum_container,forumAllPlatesFragment)
                .commit();
    }

    private void selectFragment(int num) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction()
                .hide(forumRecommendFragment).hide(forumAllPlatesFragment);
        switch (num){
            case FORUM_RECOMMEND:
                transaction.show(forumRecommendFragment);
                break;
            case FORUM_ALLPLATES:
                transaction.show(forumAllPlatesFragment);
                break;
        }
        transaction.commit();

    }

    @OnClick({R.id.forum_radioButton_recommend, R.id.forum_radioButton_allPlates})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forum_radioButton_recommend:
                selectFragment(FORUM_RECOMMEND);
                break;
            case R.id.forum_radioButton_allPlates:
                selectFragment(FORUM_ALLPLATES);
                break;
        }
    }

}
