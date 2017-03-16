package com.keye.keyevolly.http;

import com.keye.keyevolly.http.interfaces.IDataListener;
import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

import java.util.concurrent.FutureTask;

/**
 * Created by admin on 2017/3/15.
 */

public class Volley {
    /**
     * @param requestInfo
     * @param url
     * @param response
     * @param dataListener
     * @param <T>          请求参数类型
     * @param <M>          响应参数类型
     *                     暴露给调用层
     */
    public static <T, M> void sendRequest(T requestInfo, String url, Class<M> response, IDataListener dataListener) {
        RequestHolder<T> requestHodler = new RequestHolder<>();
        requestHodler.setUrl(url);
        IHttpService httpService = new JsonHttpService();
        IHttpListener httpListener = new JsonDealListener<>(response, dataListener);
        requestHodler.setHttpService(httpService);
        requestHodler.setHttpListener(httpListener);
        requestHodler.setRequestInfo(requestInfo);
        HttpTask<T> httpTask = new HttpTask<>(requestHodler);
        try {
            ThreadPoolManager.getInstance().execte(new FutureTask<Object>(httpTask, null));
        } catch (InterruptedException e) {
            dataListener.onFail();
        }
    }
}
