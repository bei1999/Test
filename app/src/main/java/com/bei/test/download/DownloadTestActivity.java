package com.bei.test.download;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bei.test.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author : lzb
 * e-mail :
 * time   : 2017/12/22
 * desc   : test
 * version: 1.0
 */
public class DownloadTestActivity extends Activity {

    @Bind(R.id.startBt)
    Button startBt;
    @Bind(R.id.pauserBt)
    Button pauserBt;
    @Bind(R.id.stopBt)
    Button stopBt;
    @Bind(R.id.stateTv)
    TextView stateTv;
    private DownloadBinder downloadBinder;
    private IDownloadAIDL mIDownloadAIDL;
    private ServiceConnection mServiceConnection;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.bind(this);

        //downloadBinder = (DownloadBinder) service;
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
//                downloadBinder = (DownloadBinder) service;
                mIDownloadAIDL = IDownloadAIDL.Stub.asInterface(service); //修改成通过aidl 接口获取binder
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        Intent intent = new Intent(DownloadTestActivity.this,DownloadService.class);

        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);

    }

    @OnClick({R.id.startBt, R.id.pauserBt, R.id.stopBt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.startBt:
//                stateTv.setText("download start :"+downloadBinder.start());
                try {
                    stateTv.setText("download start :"+mIDownloadAIDL.start());//aidl 调用start（）
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.pauserBt:
//                stateTv.setText("download pause :"+downloadBinder.onPause());
                try {
                    stateTv.setText("download pause :"+mIDownloadAIDL.onPause());//aidl 调用start（）
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.stopBt:
//                stateTv.setText("download stop :"+downloadBinder.onStop());
                try {
                    stateTv.setText("download stop :"+mIDownloadAIDL.onStop());//aidl 调用start（）
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }
}
