package com.group.yztcedu.fblife.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.ormlite.bean.User;
import com.group.yztcedu.fblife.main.ormlite.bean.UserDao;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLoginActivity extends AppCompatActivity {

    private UMShareAPI umShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }
    @OnClick(R.id.textView_login_QQ)
    public void onClick() {

        umShareAPI = UMShareAPI.get(this);
        boolean install = umShareAPI.isInstall(this, SHARE_MEDIA.QQ);
        if (!install){
            Toast.makeText(UserLoginActivity.this, "请安装手机版QQ", Toast.LENGTH_SHORT).show();
        }
        umShareAPI.doOauthVerify(this, SHARE_MEDIA.QQ, new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
               umShareAPI.getPlatformInfo(UserLoginActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                   @Override
                   public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                       User user = new User();
                       user.setName(map.get("screen_name"));
                       user.setNameID(map.get("openid"));
                       user.setImageString(map.get("profile_image_url"));
                       UserDao.add(user,UserLoginActivity.this);

                       startActivity(new Intent(UserLoginActivity.this,LoginActivity.class));
                       finish();

                   }

                   @Override
                   public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                   }

                   @Override
                   public void onCancel(SHARE_MEDIA share_media, int i) {

                   }
               });
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });


    }

}
