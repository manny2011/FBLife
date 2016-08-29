package com.group.yztcedu.fblife.main.login;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.ormlite.bean.User;
import com.group.yztcedu.fblife.main.ormlite.bean.UserDao;
import com.group.yztcedu.fblife.utils.QRUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QRCodeActivity extends AppCompatActivity {

    @BindView(R.id.imageView_QR)
    ImageView imageViewQR;
    @BindView(R.id.textView_QR_name)
    TextView textViewQRName;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        ButterKnife.bind(this);
        List<User> list = UserDao.quaryAll(this);
        User user = list.get(0);
        QRUtils.createQRCode(context,"ID:"+user.getNameID()+"\n用户名："+user.getName()+"",300,imageViewQR);
        textViewQRName.setText(user.getName());

    }
}
