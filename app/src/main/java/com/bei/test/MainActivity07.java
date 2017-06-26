package com.bei.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import com.bei.test.utils.ShareUtil;
import java.io.File;

/**
 * Created by lizhanbei on 2017/6/24.
 */

public class MainActivity07 extends Activity implements View.OnClickListener {
    Button btnQQ;
    Button btnWX;
    Button btnMore;
    Button btnWxFriendText;
    Button btnQQFriendText;
    Button btnWxFriendImg;
    Button btnQQFriendImg;
    Button btnWxFriendAudio;
    Button btnQQFriendAduio;
    Button btnWxFriendVideo;
    Button btnQQFriendVideo;

    ShareUtil shareUtil;
    private Button btn_wxCircle_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main07);
        btnQQ = (Button) findViewById(R.id.btn_qq);
        btnWX = (Button) findViewById(R.id.btn_wx);
        btnMore = (Button) findViewById(R.id.btn_more);
        btnWxFriendText = (Button) findViewById(R.id.btn_wxFriend);
        btnQQFriendText = (Button) findViewById(R.id.btn_qqFriend);
        btnWxFriendImg = (Button) findViewById(R.id.btn_wxFriend_img);
        btnQQFriendImg = (Button) findViewById(R.id.btn_qqFriend_img);
        btnWxFriendAudio = (Button) findViewById(R.id.btn_wxFriend_audio);
        btnQQFriendAduio = (Button) findViewById(R.id.btn_qqFriend_audio);
        btnWxFriendVideo = (Button) findViewById(R.id.btn_wxFriend_video);
        btnQQFriendVideo = (Button) findViewById(R.id.btn_qqFriend_video);
        btn_wxCircle_img = (Button) findViewById(R.id.btn_wxCircle_img);

        btnQQ.setOnClickListener(this);
        btnWX.setOnClickListener(this);
        btnMore.setOnClickListener(this);
        btnWxFriendText.setOnClickListener(this);
        btnQQFriendText.setOnClickListener(this);
        btnWxFriendImg.setOnClickListener(this);
        btnQQFriendImg.setOnClickListener(this);
        btnWxFriendAudio.setOnClickListener(this);
        btnQQFriendAduio.setOnClickListener(this);
        btnWxFriendVideo.setOnClickListener(this);
        btnQQFriendVideo.setOnClickListener(this);
        btn_wxCircle_img.setOnClickListener(this);

        shareUtil = new ShareUtil(this);
    }

    @Override
    public void onClick(View v) {
        String testImgPath = "/storage/emulated/legacy/display-client/picture/my.png";

        String testImagePath = Environment.getExternalStorageDirectory()
                + "/img.jpg";

        String testAudioPath = Environment.getExternalStorageDirectory()
                + "/audio.mp3";
        String testVideoPath = Environment.getExternalStorageDirectory()
                + "/video.mp4";

        File file = new File(testImgPath);
        File fileImage = new File(testImagePath);
        File fileAudio = new File(testAudioPath);
        File fileVideo = new File(testVideoPath);
        switch (v.getId()) {
            // qq&文字
            case R.id.btn_qq:
                shareUtil.shareText("com.tencent.mobileqq", null, "这是一条分享信息",
                        "分享标题", "分享主题");
                break;
            // 微信&文字
            case R.id.btn_wx:
                shareUtil.shareText("com.tencent.mm", null, "这是一条分享信息", "分享标题",
                        "分享主题");
                break;
            // 所有&文字
            case R.id.btn_more:
                shareUtil.shareText(null, null, "这是一条分享信息", "分享标题", "分享主题");
                break;
            // 微信朋友&文字
            case R.id.btn_wxFriend:
                if (shareUtil.checkInstall("com.tencent.mm")) {
                    shareUtil.shareText("com.tencent.mm",
                            "com.tencent.mm.ui.tools.ShareImgUI",
                            "http://www.aiipu.com/", "分享标题", "分享主题");
                } else {
                    shareUtil.toInstallWebView("http://weixin.qq.com/download");
                }
                break;
            // qq朋友&文字
            case R.id.btn_qqFriend:
                if (shareUtil.checkInstall("com.tencent.mobileqq")) {
                    shareUtil.shareText("com.tencent.mobileqq",
                            "com.tencent.mobileqq.activity.JumpActivity",
                            "http://www.aiipu.com/", "分享标题", "分享主题");
                } else {
                    shareUtil.toInstallWebView("http://im.qq.com/mobileqq/");
                }
                break;
            // 微信朋友&图片
            case R.id.btn_wxFriend_img:
                shareUtil.shareImg("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareImgUI", fileImage);
                break;
            // qq朋友&图片
            case R.id.btn_qqFriend_img:
                shareUtil.shareImg("com.tencent.mobileqq",
                        "com.tencent.mobileqq.activity.JumpActivity", fileImage);
                break;
            case R.id.btn_wxFriend_audio:
                shareUtil.shareAudio("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareImgUI", fileAudio);
                break;
            case R.id.btn_qqFriend_audio:
                shareUtil.shareAudio("com.tencent.mobileqq",
                        "com.tencent.mobileqq.activity.JumpActivity", fileAudio);
                break;
            case R.id.btn_wxFriend_video:
                shareUtil.shareVideo("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareImgUI", fileVideo);
                break;
            case R.id.btn_qqFriend_video:
                shareUtil.shareVideo("com.tencent.mobileqq",
                        "com.tencent.mobileqq.activity.JumpActivity", fileVideo);
                break;
            case R.id.btn_wxCircle_img:
                shareUtil.shareImgToWXCircle("狗狗图片", "com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareToTimeLineUI", fileImage);
                break;
        }
    }
}