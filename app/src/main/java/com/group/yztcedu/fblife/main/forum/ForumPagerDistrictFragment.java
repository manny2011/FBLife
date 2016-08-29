package com.group.yztcedu.fblife.main.forum;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.config.UrlConfig_Forum;
import com.group.yztcedu.fblife.main.forum.entity.BbsinfoBean;
import com.group.yztcedu.fblife.main.forum.entity.PlatesBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/5.
 */
public class ForumPagerDistrictFragment extends Fragment implements ForumContract.View1{


    @BindView(R.id.forum_district_expandable)
    ExpandableListView forumDistrictExpandable;
    ForumContract.Presenter1 presenter1 ;/** 父类对象的引用指向子类的对象*/
    HashMap<String,String > params;
    AllPlatesAdapter adapter;
    List<BbsinfoBean> mList;
    private String category;

    ImageView NonetImageView;
    AnimationDrawable mFrameAnimation;
    ImageView ShowAnimationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_district_expandable_listview, null);
        ButterKnife.bind(this, view);

        NonetImageView= (ImageView) view.findViewById(R.id.forum_loading_pic);
        mFrameAnimation= (AnimationDrawable) getResources().getDrawable(R.drawable.mframeanimation);
        ShowAnimationView= (ImageView) view.findViewById(R.id.animation);
        ShowAnimationView.setBackgroundDrawable(mFrameAnimation);
        mFrameAnimation.start();

        /**接收从父fragment或者activity中获得传过来的数据;*/
        Bundle args = getArguments();
        String categoryValue= (String) args.get("category");
        if(categoryValue=="diqu"){
            category="diqu";
        }else if(categoryValue=="chexing"){
            category="chexing";
        }else if(categoryValue=="zhuti"){
            category="zhuti";
        }else if(categoryValue=="jiaoyi"){
            category="jiaoyi";
        }
        initParams();
        mList=new ArrayList<>();
        presenter1 = new ForumPresenter(this);
        presenter1.getPlateBean(params);
        adapter = new AllPlatesAdapter(getContext(),mList);
        forumDistrictExpandable.setAdapter(adapter);
        return view;
    }


    @Override
    public void onSuccess(PlatesBean platesBean) {
        mList.addAll(platesBean.getBbsinfo());
        if(mFrameAnimation!=null&&mFrameAnimation.isRunning()){
            NonetImageView.setAlpha(0);
            ShowAnimationView.setAlpha(0);
            mFrameAnimation.stop();
            mFrameAnimation.setAlpha(0);

        }
        Log.i("TAG",platesBean.getBbsinfo().toString());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailed(String s) {
        /**失败后,提示点击页面,重新加载*/
        if(mFrameAnimation!=null&&mFrameAnimation.isRunning()){
            mFrameAnimation.stop();
            mFrameAnimation.setAlpha(0);
            ShowAnimationView.setAlpha(0);
            NonetImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mFrameAnimation.start();
                    mFrameAnimation.setAlpha(1);
                    ShowAnimationView.setAlpha(1);
                    Log.i("TAG","is clicked");
                    presenter1.getPlateBean(params);
                }
            });

        }
    }
    void initParams(){
        params = new HashMap<>();
        params.put(UrlConfig_Forum.DistrictKey.authcode,UrlConfig_Forum.DistrictValue.authcode);
        params.put(UrlConfig_Forum.DistrictKey.categorytype,category);
        params.put(UrlConfig_Forum.DistrictKey.formattype,UrlConfig_Forum.DistrictValue.formattype);

    };
}
