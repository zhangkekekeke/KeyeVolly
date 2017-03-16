package com.keye.keyevolly.http;

import com.alibaba.fastjson.JSON;
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
        T request = requestHolder.getRequestInfo();
        String requestInfo = JSON.toJSONString(request);

        try {
            httpService.setRequeestData(requestInfo.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        httpService.excute();
    }
}
