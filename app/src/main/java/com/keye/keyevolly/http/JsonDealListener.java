package com.keye.keyevolly.http;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;
import com.keye.keyevolly.http.interfaces.IDataListener;
import com.keye.keyevolly.http.interfaces.IHttpListener;

import org.apache.http.HttpEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static android.os.Build.ID;

/**
 * Created by admin on 2017/3/15.
 */

public class JsonDealListener<M> implements IHttpListener {
    private Class<M> responseClass;
    /**
     * 回调调用层 的接口
     */
    private IDataListener<M> dataListener;
    /**
     * 获取主线程的Handler
     * 通过                                                                                                 handler切换至主线程
     */
    Handler handler = new Handler(Looper.getMainLooper());

    public JsonDealListener(Class<M> responseClass, IDataListener<M> dataListener) {
        this.responseClass = responseClass;
        this.dataListener = dataListener;
    }

    @Override
    public void onSuccess(HttpEntity httpEntity) {
        InputStream inputStream = null;

        try {
            inputStream = httpEntity.getContent();
            String content = getContent(inputStream);
            final M response = JSON.parseObject(content, responseClass);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    dataListener.onSuccess(response);
                }
            });
        } catch (IOException e) {
            dataListener.onFail();
            e.printStackTrace();
        }

    }

    private String getContent(InputStream inputStream) {
        String content = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();

        String line = null;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            dataListener.onFail();
        } finally {

            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("Error=" + e.toString());
            }
        }

        return sb.toString();
    }

    @Override
    public void onFail() {
        dataListener.onFail();
    }

    @Override
    public void addHttpHeader(Map<String, String> headerMap) {

    }

}
