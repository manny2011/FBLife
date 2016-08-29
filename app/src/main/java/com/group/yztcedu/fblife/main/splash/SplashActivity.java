package com.group.yztcedu.fblife.main.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.base.BaseActivity;
import com.group.yztcedu.fblife.config.UrlConfig_Splash;
import com.group.yztcedu.fblife.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/8/3.
 */
public class SplashActivity extends BaseActivity {
//
    private final long SPLASH_LENGTH = 3000;
    Handler handler = new Handler();
    @BindView(R.id.splash_image)
    ImageView splashImage;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private Runnable runnabel;
    private Boolean isStop = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        Glide.with(getBaseContext())
                .load(UrlConfig_Splash.COVER_PIC)
                .into(splashImage);
        splashImage.setScaleType(ImageView.ScaleType.FIT_XY);

        //使用handler的postDelayed实现延时跳转
// SPLASH_LENGTH);//2秒后跳转至应用主界面MainActivity

        handler.postDelayed(runnabel = new Runnable() {  //使用handler的postDelayed实现延时跳转
            public void run() {
                    if(!isStop) {
                    progressBar.setClickable(false);
                    Log.i("TAG", "new Runnable");
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_LENGTH);

    }
    @OnClick(R.id.progressBar)
    public void onClick() {
//当进度圈被点击,新线程不可再开启;
        isStop=true;
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
