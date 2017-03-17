package com.keye.keyevolly.http.download;

import com.keye.keyevolly.http.HttpTask;

/**
 * Created by admin on 2017/3/16.
 */

public class DownloadItemInfo extends BaseEntity<DownloadItemInfo> {
    private long currentLength;
    private long totalLength;
    private String url;
    private String filePath;

    private transient HttpTask httpTask;
    //下载的状态
    private DownloadStatus downloadStatus;

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public DownloadItemInfo(String url, String filePath) {
        this.url = url;
        this.filePath = filePath;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public long getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(long totalLength) {
        this.totalLength = totalLength;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public HttpTask getHttpTask() {
        return httpTask;
    }

    public void setHttpTask(HttpTask httpTask) {
        this.httpTask = httpTask;
    }

    public long getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(long currentLength) {
        this.currentLength = currentLength;
    }
}
