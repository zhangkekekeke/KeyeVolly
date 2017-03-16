package com.keye.keyevolly.http;

import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by admin on 2017/3/15.
 */

public class JsonHttpService implements IHttpService {
    private IHttpListener httpListener;

    private HttpClient httpClient = new DefaultHttpClient();
    private HttpPost httpPost;
    private String url;

    private byte[] requestDate;

    /**
     * httpClient获取网络的回调
     */
    private HttpResponseHandler httpResponseHandler = new HttpResponseHandler();


    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void excute() {
        httpPost = new HttpPost(url);
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(requestDate);
        httpPost.setEntity(byteArrayEntity);
        try {
            httpClient.execute(httpPost, httpResponseHandler);
        } catch (IOException e) {
            httpListener.onFail();
            e.printStackTrace();
        }
    }

    @Override
    public void setHttpListener(IHttpListener httpListener) {
        this.httpListener = httpListener;
    }

    @Override
    public void setRequeestData(byte[] requeestData) {
        this.requestDate = requeestData;
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
