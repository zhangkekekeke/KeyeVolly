package com.keye.keyevolly.http.interfaces;

/**
 * Created by admin on 2017/3/15.
 */

import org.apache.http.HttpEntity;

import java.util.Map;

/**
 * 处理结果
 */
public interface IHttpListener {
    /**
     * 网络访问
     * 处理结果 回调
     *
     * @param httpEntity
     */
    void onSuccess(HttpEntity httpEntity);

    void onFail();

    void addHttpheader(Map<String, String> headerMap);
}
