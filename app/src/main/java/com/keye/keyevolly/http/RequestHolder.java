package com.keye.keyevolly.http;

import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

/**
 * Created by admin on 2017/3/15.
 */

public class RequestHolder<T> {
    /**
     * 执行下载类
     */
    private IHttpService httpService;

    /**
     * 获取数据 回调结果的类
     */
    private IHttpListener httpListener;

    /**
     * 请求参数对应的实体
     */
    private T requestInfo;

    private String url;

    public IHttpService getHttpService() {
        return httpService;
    }

    public void setHttpService(IHttpService httpService) {
        this.httpService = httpService;
    }

    public IHttpListener getHttpListener() {
        return httpListener;
    }

    public void setHttpListener(IHttpListener httpListener) {
        this.httpListener = httpListener;
    }

    public T getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(T requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
