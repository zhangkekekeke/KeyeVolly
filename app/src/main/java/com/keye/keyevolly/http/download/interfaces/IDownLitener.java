package com.keye.keyevolly.http.download.interfaces;


import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public interface IDownLitener  extends IHttpListener {

    void setHttpServive(IHttpService httpServive);


    void  setCancleCalle();


    void  setPuaseCallble();

}
