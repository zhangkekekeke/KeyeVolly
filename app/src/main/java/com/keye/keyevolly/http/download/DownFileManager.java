package com.keye.keyevolly.http.download;

import android.os.Environment;
import android.util.Log;

import com.keye.keyevolly.http.HttpTask;
import com.keye.keyevolly.http.RequestHolder;
import com.keye.keyevolly.http.ThreadPoolManager;
import com.keye.keyevolly.http.download.interfaces.IDownloadServiceCallable;
import com.keye.keyevolly.http.interfaces.IHttpListener;
import com.keye.keyevolly.http.interfaces.IHttpService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.FutureTask;

/**
 * Created by admin on 2017/3/16.
 */

public class DownFileManager implements IDownloadServiceCallable {
    private byte[] lock = new byte[0];
    private String TAG = "KEYE";

    /**
     * 下载
     *
     * @param url
     */
    public void down(String url) {
        String[] preFixs = url.split("/");
        String afterFix = preFixs[preFixs.length - 1];

        File file = new File(Environment.getExternalStorageDirectory(), afterFix);
        //实例化DownItemInfo
        DownloadItemInfo downloadItemInfo = new DownloadItemInfo(url, file.getAbsolutePath());

        synchronized (lock) {
            RequestHolder requestHolder = new RequestHolder();
            //设置请求下载的策略
            IHttpService httpService = new FileDownHttpService();
            //得到请求头的参数map
            Map<String, String> map = httpService.getHttpHeadMap();
            /**
             * 处理结果的策略
             */
            IHttpListener httpListener = new DownLoadListener(downloadItemInfo, this, httpService);

            requestHolder.setHttpListener(httpListener);
            requestHolder.setRequestInfo(downloadItemInfo);
            requestHolder.setHttpService(httpService);
            requestHolder.setUrl(url);
            HttpTask httpTask = new HttpTask(requestHolder);

            try {
                ThreadPoolManager.getInstance().execte(new FutureTask<Object>(httpTask, null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        IHttpService httpService = new FileDownHttpService();
        Map<String, String> map = httpService.getHttpHeadMap();
    }

    @Override
    public void onDownloadStatusChanged(DownloadItemInfo downloadItemInfo) {

    }

    @Override
    public void onTotalLengthReceived(DownloadItemInfo downloadItemInfo) {

    }

    @Override
    public void onCurrentSizeChanged(DownloadItemInfo downloadItemInfo, double downLenth, long speed) {
        Log.i(TAG, "下载速度：" + speed / 1000 + "k/s");
        Log.i(TAG, "-----路径  " + downloadItemInfo.getFilePath() + "  下载长度  " + downLenth + "   速度  " + speed);
    }

    @Override
    public void onDownloadSuccess(DownloadItemInfo downloadItemInfo) {
        Log.i(TAG, "下载成功    路劲  " + downloadItemInfo.getFilePath() + "  url " + downloadItemInfo.getUrl());
    }

    @Override
    public void onDownloadPause(DownloadItemInfo downloadItemInfo) {

    }

    @Override
    public void onDownloadError(DownloadItemInfo downloadItemInfo, int var2, String var3) {

    }
}
