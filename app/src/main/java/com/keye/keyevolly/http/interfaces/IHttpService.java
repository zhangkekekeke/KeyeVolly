package com.keye.keyevolly.http.interfaces;

/**
 * Created by admin on 2017/3/15.
 */

import java.util.Map;

/**
 * 获取网络
 */
public interface IHttpService {
    /**
     * 设置url
     *
     * @param url
     */
    void setUrl(String url);

    /**
     * 执行获取网络
     */
    void excute();

    /**
     * 设置处理接口
     *
     * @param httpListener
     */
    void setHttpListener(IHttpListener httpListener);

    /**
     * 设置请求参数
     */
    void setRequeestData(byte[] requeestData);


    void pause();

    boolean isPause();

    /**
     * 获取请求头的map
     *
     * @return
     */
    Map<String, String> getHttpHeadMap();

    boolean cancel();

    boolean isCancel();
}
