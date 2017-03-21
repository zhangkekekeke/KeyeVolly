package com.keye.keyevolly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.keye.keyevolly.bean.LoginResopense;
import com.keye.keyevolly.bean.User;
import com.keye.keyevolly.http.Volley;
import com.keye.keyevolly.http.download.DownFileManager;
import com.keye.keyevolly.http.interfaces.IDataListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String url = "http://192.168.100.24:8080/UserRecord/LoginServlet";
    private static final String TAG = "keye";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * keye
     *
     * @param view
     */
    public void login(View view) {

//        for (int i = 0; i < 50; i++) {
//
//            User user = new User();
//            user.setName("123123");
//            user.setPassword("12354");
//            Volley.sendRequest(user, url, LoginResopense.class, new IDataListener<LoginResopense>() {
//                @Override
//                public void onSuccess(LoginResopense loginRespense) {
//                    Log.i(TAG, loginRespense.toString());
//                }
//
//                @Override
//                public void onFail() {
//                    Log.i(TAG, "获取失败");
//                }
//            });
//
//        }

        DownFileManager downFileManage=new DownFileManager();
        downFileManage.down("http://gdown.baidu.com/data/wisegame/8be18d2c0dc8a9c9/WPSOffice_177.apk");

    }

}
