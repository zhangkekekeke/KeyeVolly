package com.keye.keyevolly.http.download;

/**
 * Created by admin on 2017/3/16.
 */

public enum DownloadStatus {

    waitting(0),

    starting(1),

    downloading(2),

    finish(4),

    failed(5);

    private int value;

    DownloadStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
