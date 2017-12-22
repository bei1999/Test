package com.bei.test.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/22
 * desc   : 构建下载服务
 * version: 1.0
 */
public class DownloadService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new DownloadBinder();
    }
}
