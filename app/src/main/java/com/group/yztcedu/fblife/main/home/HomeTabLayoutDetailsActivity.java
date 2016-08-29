package com.group.yztcedu.fblife.main.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseActivity;
import com.group.yztcedu.fblife.widget.FlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTabLayoutDetailsActivity extends BaseActivity {
    @BindView(R.id.home_tabLayout_details_toolbar)
    Toolbar homeTabLayoutDetailsToolbar;
    private FlowLayout mFlowLayout;
    private String[] mNames = {"首页", "新车", "导购", "试驾", "图集", "降价", "文化", "改装", "旅游", "行业", "房车", "铁骑", "活动", "用车", "赛事"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab_layout_details);
        ButterKnife.bind(this);
        homeTabLayoutDetailsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initChildViews();
    }

    private void initChildViews() {
        mFlowLayout = (FlowLayout) findViewById(R.id.flowLayout);
        MarginLayoutParams lp = new MarginLayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 20;
        lp.rightMargin = 20;
        lp.topMargin = 20;
        lp.bottomMargin = 20;
        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.BLACK);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            mFlowLayout.addView(view, lp);

        }
    }

}
