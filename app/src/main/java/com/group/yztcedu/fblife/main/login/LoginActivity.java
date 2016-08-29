package com.group.yztcedu.fblife.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.login.zxing.android.CaptureActivity;
import com.group.yztcedu.fblife.main.ormlite.bean.User;
import com.group.yztcedu.fblife.main.ormlite.bean.UserDao;
import com.group.yztcedu.fblife.main.search.SearchActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.imageView_login_back)
    ImageView imageViewLoginBack;
    @BindView(R.id.linearLayout_login)
    LinearLayout linearLayoutLogin;
    @BindView(R.id.linearLayout_login_save)
    LinearLayout linearLayoutLoginSave;
    @BindView(R.id.linearLayout_login_invitation)
    LinearLayout linearLayoutLoginInvitation;
    @BindView(R.id.linearLayout_login_friend)
    LinearLayout linearLayoutLoginFriend;
    @BindView(R.id.linearLayout_login_saoyisao)
    LinearLayout linearLayoutLoginSaoyisao;
    @BindView(R.id.linearLayout_login_SMS)
    LinearLayout linearLayoutLoginSMS;
    @BindView(R.id.linearLayout_login_draft)
    LinearLayout linearLayoutLoginDraft;
    @BindView(R.id.linearLayout_login_search)
    LinearLayout linearLayoutLoginSearch;
    @BindView(R.id.linearLayout_login_setting)
    LinearLayout linearLayoutLoginSetting;
    @BindView(R.id.imageView_login)
    ImageView imageViewLogin;
    @BindView(R.id.textView_login)
    TextView textViewLogin;
    @BindView(R.id.textView_login_quit)
    TextView textViewLoginQuit;
    private List<User> list;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initLogin();
    }

    private void initLogin() {
        list = UserDao.quaryAll(this);
        if (list.size() != 0) {
            user = list.get(0);
            Glide.with(this).load(user.getImageString()).into(imageViewLogin);
            textViewLogin.setText(user.getName());
            textViewLoginQuit.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.imageView_login_back, R.id.linearLayout_login, R.id.linearLayout_login_save, R.id.linearLayout_login_invitation, R.id.linearLayout_login_friend, R.id.linearLayout_login_saoyisao, R.id.linearLayout_login_SMS, R.id.linearLayout_login_draft, R.id.linearLayout_login_search, R.id.linearLayout_login_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_login_back:
                finish();
                break;
            case R.id.linearLayout_login:
                List<User> mList = UserDao.quaryAll(this);
                if (mList.size() != 0) {

                } else {
                    startActivity(new Intent(this, UserLoginActivity.class));
                    finish();
                }

                break;
            case R.id.linearLayout_login_save:
                break;
            case R.id.linearLayout_login_invitation:
                break;
            case R.id.linearLayout_login_friend:
                break;
            case R.id.linearLayout_login_saoyisao:
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.linearLayout_login_SMS:

                break;
            case R.id.linearLayout_login_draft:

                break;
            case R.id.linearLayout_login_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.linearLayout_login_setting:

                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                String codedContent = data.getStringExtra("codedContent");
                //再次用Base64解码.
                Toast.makeText(LoginActivity.this, codedContent, Toast.LENGTH_SHORT).show();

            }
        }
    }

    @OnClick(R.id.textView_login_quit)
    public void onClick() {
        imageViewLogin.setImageResource(R.mipmap.user_default);
        textViewLogin.setText("立即登入");
        UserDao.delAll(this,user);
        textViewLoginQuit.setVisibility(View.GONE);
    }
}
