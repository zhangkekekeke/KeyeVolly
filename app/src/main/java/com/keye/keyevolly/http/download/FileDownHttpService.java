package com.keye.keyevolly.http.download;

import android.util.Log;

import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by admin on 2017/3/16.
 */

public class FileDownHttpService implements IHttpService {

    /**
     * 即将添加到请求头的信息
     */
    private Map<String, String> headerMap = Collections.synchronizedMap(new HashMap<String, String>());

    /**
     * 含有请求处理的 接口
     */
    private IHttpListener httpListener;

    private HttpClient httpClient = new DefaultHttpClient();
    private HttpGet httpGet;
    private String url;

    private byte[] requestData;

    /**
     * httpClient获取网络的回调
     */
    private HttpResponseHandler httpResponseHandler = new HttpResponseHandler();
    private String TAG = "KEYE";

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void excute() {
        httpGet = new HttpGet(url);
        constractHeader();
//        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(requestData);
//        httpGet.setEntity(byteArrayEntity);
        try {
            httpClient.execute(httpGet, httpResponseHandler);
        } catch (IOException e) {
            httpListener.onFail();
            e.printStackTrace();
        }
    }

    private void constractHeader() {
        Iterator iterator = headerMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = headerMap.get(key);
            Log.i(TAG, "请求头信息 " + key + " value" + value);
        }
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    @Override
    public void setHttpListener(IHttpListener httpListener) {
        this.httpListener = httpListener;
    }

    @Override
    public void setRequeestData(byte[] requeestData) {

    }

    @Override
    public void pause() {

    }

    @Override
    public boolean isPause() {

        return false;
    }

    @Override
    public Map<String, String> getHttpHeadMap() {
        return getHeaderMap();
    }

    @Override
    public boolean cancel() {
        return false;
    }

    @Override
    public boolean isCancel() {
        return false;
    }


    private class HttpResponseHandler extends BasicResponseHandler {
        @Override
        public String handleResponse(HttpResponse response) throws HttpResponseException, ClientProtocolException {
            //响应码
            int code = response.getStatusLine().getStatusCode();
            if (code == 200) {
                httpListener.onSuccess(response.getEntity());
            } else {
                httpListener.onFail();
            }
            return null;
        }
    }
}
