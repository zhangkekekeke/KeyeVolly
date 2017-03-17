package com.keye.keyevolly.http;

import com.alibaba.fastjson.JSON;
import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

import java.io.UnsupportedEncodingException;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by admin on 2017/3/15.
 */

public class HttpTask<T> implements Runnable {
    private IHttpService httpService;

    public HttpTask(RequestHolder<T> requestHolder) {
        httpService = requestHolder.getHttpService();
        httpService.setHttpListener(requestHolder.getHttpListener());
        httpService.setUrl(requestHolder.getUrl());

        //增加方法
        IHttpListener httpListener = requestHolder.getHttpListener();
        httpListener.addHttpheader(httpService.getHttpHeadMap());

        try {
            T request = requestHolder.getRequestInfo();
            if (request != null) {
                String requestInfo = JSON.toJSONString(request);
                httpService.setRequeestData(requestInfo.getBytes("UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        httpService.excute();
    }
}
