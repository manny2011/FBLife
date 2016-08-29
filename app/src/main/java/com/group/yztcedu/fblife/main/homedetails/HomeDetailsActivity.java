package com.group.yztcedu.fblife.main.homedetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.login.UserLoginActivity;
import com.group.yztcedu.fblife.main.ormlite.bean.User;
import com.group.yztcedu.fblife.main.ormlite.bean.UserDao;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeDetailsActivity extends AppCompatActivity {

    @BindView(R.id.home_details_ivBack)
    ImageView homeDetailsIvBack;
    @BindView(R.id.home_details_ivWrite)
    ImageView homeDetailsIvWrite;
    @BindView(R.id.home_details_ivShare)
    ImageView homeDetailsIvShare;
    @BindView(R.id.home_details_ivCollect)
    ImageView homeDetailsIvCollect;
    @BindView(R.id.home_details_ivMore)
    ImageView homeDetailsIvMore;

    private List<User> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_details);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_details_ivBack, R.id.home_details_ivWrite, R.id.home_details_ivShare, R.id.home_details_ivCollect, R.id.home_details_ivMore, R.id.homeDetails_ll})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_details_ivBack:
                finish();
                break;
            case R.id.home_details_ivWrite:
                mList = UserDao.quaryAll(this);
                if (mList.size() != 0) {

                } else {
                    startActivity(new Intent(this, UserLoginActivity.class));

                }
                break;
            case R.id.home_details_ivShare:
                //分享


                SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                        {
                                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SINA,
                                SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,SHARE_MEDIA.TENCENT
                        };

                UMShareListener umShareListener = new UMShareListener() {
                    @Override
                    public void onResult(SHARE_MEDIA platform) {
                        Toast.makeText(HomeDetailsActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA platform, Throwable t) {
                        Toast.makeText(HomeDetailsActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA platform) {
                        Toast.makeText(HomeDetailsActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
                    }
                };

                new ShareAction(this).setDisplayList(displaylist)
                        .withText("汽车之家")
                        .withTitle("汽车")
                        .withTargetUrl("http://www.baidu.com")
                        .setListenerList(umShareListener)
                        .open();

            break;
            case R.id.home_details_ivCollect:
                mList = UserDao.quaryAll(this);
                if (mList.size() != 0) {

                } else {
                    startActivity(new Intent(this, UserLoginActivity.class));

                }
                break;
            case R.id.home_details_ivMore:

                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
