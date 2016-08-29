package com.group.yztcedu.fblife.main.forum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group.yztcedu.fblife.R;

/**
 * Created by Administrator on 2016/8/5.
 */
public class ForumPagerThemeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_theme_expandable_listview, null);


        return view;
    }
}
