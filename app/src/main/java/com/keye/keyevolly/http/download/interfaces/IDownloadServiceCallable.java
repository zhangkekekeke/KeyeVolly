package com.keye.keyevolly.http.download.interfaces;

import com.keye.keyevolly.http.download.DownloadItemInfo;

/**
 * Created by admin on 2017/3/16.
 */

public interface IDownloadServiceCallable {
    void onDownloadStatusChanged(DownloadItemInfo downloadItemInfo);

    void onTotalLengthReceived(DownloadItemInfo downloadItemInfo);

    void onCurrentSizeChanged(DownloadItemInfo downloadItemInfo, double downLength, long speed);

    void onDownloadSuccess(DownloadItemInfo downloadItemInfo);

    void onDownloadPause(DownloadItemInfo downloadItemInfo);

    void onDownloadError(DownloadItemInfo downloadItemInfo, int var2, String var3);
}
