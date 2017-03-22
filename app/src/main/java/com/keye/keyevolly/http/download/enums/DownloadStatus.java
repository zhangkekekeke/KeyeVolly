package com.keye.keyevolly.http.download.enums;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public enum  DownloadStatus {
    waitting(0),

    starting(1),

    downloading(2),

    pause(3),

    finish(4),

    failed(5)
    ;

    private int value;
    private   DownloadStatus(int value)
    {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
