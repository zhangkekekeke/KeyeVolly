package com.keye.keyevolly.http.download.interfaces;

import com.keye.keyevolly.http.interfaces.IHttpListener;

/**
 * Created by admin on 2017/3/16.
 */

public interface IDownListener extends IHttpListener {

    void setHttpService(IHttpListener httpService);

    void setCancleCall();

    void setPuaseCall();
}
