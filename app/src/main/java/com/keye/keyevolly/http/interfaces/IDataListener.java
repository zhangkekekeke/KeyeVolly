package com.keye.keyevolly.http.interfaces;

/**
 * Created by admin on 2017/3/15.
 */


public interface IDataListener<M> {
    /**
     * 回调结果给调用层
     *
     * @param m
     */
    void onSuccess(M m);

    void onFail();
}
