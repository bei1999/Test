package com.bei.test.download;

import android.os.Binder;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/22
 * desc   :
 * version: 1.0
 */
public class DownloadBinder extends IDownloadAIDL.Stub {
    @Override
    public boolean start() {
        return true;

    }

    @Override
    public boolean onPause() {
        return true;

    }

    @Override
    public boolean onStop() {
        return true;

    }
}
