package com.keye.keyevolly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.keye.keyevolly.bean.GameResult;
import com.keye.keyevolly.bean.UpdataResults;
import com.keye.keyevolly.bean.UpdateResponse;
import com.keye.keyevolly.http.Volley;
import com.keye.keyevolly.http.interfaces.IDataListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //    public static final String url = "http://192.168.100.24:8080/UserRecord/LoginServlet";
//    public static final String url = "http://114.215.24.252:9090/weixin_guide/api/information/homework?patientid=51e427b920664364b95d75ae85250db4";
    public static final String url = "http://114.215.24.252:9090/weixin_guide/api/information/gameresult/";
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
//        User user = new User();
//        user.setName("123123");
//        user.setPassword("12354");

        GameResult gameResult = initDate();
        List<GameResult> lists = new ArrayList<>();
        lists.add(gameResult);
        UpdataResults upResults = new UpdataResults("51e427b920664364b95d75ae85250db4", lists);
        Volley.sendRequest(upResults, url, UpdateResponse.class, new IDataListener<UpdateResponse>() {
            @Override
            public void onSuccess(UpdateResponse loginRespense) {
                Log.i(TAG, loginRespense.toString());
            }

            @Override
            public void onFail() {
                Log.i(TAG, "获取失败");
            }
        });

    }

    private GameResult initDate() {
        GameResult gameResult = new GameResult();
        gameResult.setIdGameReult((int) System.currentTimeMillis());
        gameResult.setPatientId("51e427b920664364b95d75ae85250db4");
        gameResult.setGameId("数字卡片");
        gameResult.setHardLevel(1);
        gameResult.setForceLevel(0);
        gameResult.setHandType(0);
        gameResult.setSetTime(1f);
        gameResult.setScore(1);
        gameResult.setCompleteTime(1);
        gameResult.setPercentage(0);
        gameResult.setCorrectlyNum(0);
        gameResult.setAverageReaction(1f);
        gameResult.setAverageAccuracy(1f);
        gameResult.setCreatUser("");
        gameResult.setCreatTime(Calendar.getInstance().getTime());
        gameResult.setRemarks("");
        gameResult.setUpdata(false);
        return gameResult;
    }
}
