//package com.bei.test;
//
//import android.content.Context;
//import android.content.pm.ActivityInfo;
//import android.content.res.Configuration;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.TypedValue;
//import android.view.Gravity;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.TextView;
//
//import com.jude.dome.DataProvider;
//import com.jude.dome.Utils;
//import com.jude.dome.horizontal.NarrowImageAdapter;
//import com.jude.dome.loadmore.PersonAdapter;
//import com.jude.easyrecyclerview.EasyRecyclerView;
//import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
//import com.jude.easyrecyclerview.decoration.DividerDecoration;
//import com.jude.easyrecyclerview.decoration.SpaceDecoration;
//import com.jude.rollviewpager.RollPagerView;
//import com.jude.rollviewpager.Util;
//import com.jude.rollviewpager.hintview.ColorPointHintView;
//import com.longtailvideo.jwplayer.JWPlayerView;
//import com.longtailvideo.jwplayer.configuration.PlayerConfig;
//import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;
//
///**
// * Created by Mr.Jude on 2016/1/6.
// */
//public class HeaderFooterActivity extends AppCompatActivity {
//    private EasyRecyclerView recyclerView;
//    private PersonAdapter adapter;
//    private WebView webView;
//    private WebSettings webSettings;
//    private WebViewClient wvc;
//    private JWPlayerView playerView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recyclerview);
//        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(adapter = new PersonAdapter(this));
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(this,0.5f), Util.dip2px(this,72),0);
//        itemDecoration.setDrawLastItem(true);
//        itemDecoration.setDrawHeaderFooter(true);
//        recyclerView.addItemDecoration(itemDecoration);
//        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                recyclerView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        adapter.clear();
//                        adapter.addAll(DataProvider.getPersonList(0));
//                    }
//                },1500);
//            }
//        });
//
//        initPlayer();
//        initwebview(HeaderFooterActivity.this);
//
//
//        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
//            @Override
//            public View onCreateView(ViewGroup parent) {
//                RollPagerView header = new RollPagerView(HeaderFooterActivity.this);
//                header.setHintView(new ColorPointHintView(HeaderFooterActivity.this, Color.YELLOW, Color.GRAY));
//                header.setHintPadding(0, 0, 0, (int) Utils.convertDpToPixel(8, HeaderFooterActivity.this));
//                header.setPlayDelay(2000);
//                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Utils.convertDpToPixel(200, HeaderFooterActivity.this)));
//                header.setAdapter(new BannerAdapter(HeaderFooterActivity.this));
//                return header;
//            }
//
//            @Override
//            public void onBindView(View headerView) {
//
//            }
//        });
//
//        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
//            @Override
//            public View onCreateView(ViewGroup parent) {
////                playerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Utils.convertDpToPixel(400, HeaderFooterActivity.this)));
//
//
//                return playerView;
//            }
//
//            @Override
//            public void onBindView(View headerView) {
//
//            }
//        });
//
//        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
//            @Override
//            public View onCreateView(ViewGroup parent) {
//                RecyclerView recyclerView = new RecyclerView(parent.getContext()){
//                    //为了不打扰横向RecyclerView的滑动操作，可以这样处理
//                    @Override
//                    public boolean onTouchEvent(MotionEvent event) {
//                        super.onTouchEvent(event);
//                        return true;
//                    }
//                };
//                recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,(int) Utils.convertDpToPixel(300, HeaderFooterActivity.this)));
//                final NarrowImageAdapter adapter;
//                recyclerView.setAdapter(adapter = new NarrowImageAdapter(parent.getContext()));
//                recyclerView.setLayoutManager(new LinearLayoutManager(parent.getContext(), LinearLayoutManager.HORIZONTAL,false));
//                recyclerView.addItemDecoration(new SpaceDecoration((int) Utils.convertDpToPixel(8,parent.getContext())));
//                adapter.setMore(R.layout.view_more_horizontal, new RecyclerArrayAdapter.OnLoadMoreListener() {
//                    @Override
//                    public void onLoadMore() {
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                adapter.addAll(DataProvider.getNarrowImage(0));
//                            }
//                        },1000);
//                    }
//                });
//                adapter.addAll(DataProvider.getNarrowImage(0));
//                return recyclerView;
//            }
//
//            @Override
//            public void onBindView(View headerView) {
//                //这里的处理别忘了
//                ((ViewGroup)headerView).requestDisallowInterceptTouchEvent(true);
//            }
//        });
//
//        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
//            @Override
//            public View onCreateView(ViewGroup parent) {
//                return webView;
//            }
//
//            @Override
//            public void onBindView(View headerView) {
////                ((ViewGroup)headerView).requestDisallowInterceptTouchEvent(false);
//
//            }
//        });
//
//        adapter.addFooter(new RecyclerArrayAdapter.ItemView() {
//            @Override
//            public View onCreateView(ViewGroup parent) {
//                TextView tv = new TextView(HeaderFooterActivity.this);
//                tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) Utils.convertDpToPixel(56,HeaderFooterActivity.this)));
//                tv.setGravity(Gravity.CENTER);
//                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
//                tv.setText("(-_-)/~~~死宅真是恶心");
//                return tv;
//            }
//
//            @Override
//            public void onBindView(View headerView) {
//
//            }
//        });
//        adapter.addAll(DataProvider.getPersonList(0));
//    }
//
//    private void initPlayer() {
//        PlayerConfig playerConfig = new PlayerConfig.Builder()
//                .stretching(PlayerConfig.STRETCHING_EXACT_FIT)
//                .autostart(false)
//                .build();
//
//        playerView = new JWPlayerView(this, playerConfig);
//
////        playerView.post(new Runnable() {
////            @Override
////            public void run() {
////                playerView.setLayoutParams(
////                        new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
////                                calculateHeight(playerView.getWidth()))); // Force 16:9 aspect ratio
////            }
////        });
//        playerView.setLayoutParams(
//                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                        (int) Utils.convertDpToPixel(300, HeaderFooterActivity.this))); // Force 16:9 aspect ratio
//
//        playerView.setFullscreen(false, false);
//        PlaylistItem playlistItem = new PlaylistItem.Builder()
//                .file("http://news.cctvnews.cn/resource/live/french/cctv-f.m3u8")
//                .image("http://news.cctvnews.cn/resource/live/french/cctv-f.png")
//                .build();
//
//        playerView.load(playlistItem);
//
//    }
//
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ) {
//            //屏蔽回到直播页可能出现的横屏
//            if(!playerView.getFullscreen()){
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//            }
//        }
//        //屏蔽全屏时可能出现的竖屏
//        if (playerView.getFullscreen()) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
//        super.onConfigurationChanged(newConfig);
//
//    }
//
//    private int calculateHeight(int width) {
//        return (width / 16) * 9; // 16:9 aspect ratio
//    }
//
//    private void initwebview(Context context) {
//        webView = new WebView(context);
//        webView.getSettings().setJavaScriptEnabled(true);
////        webView.getSettings().setAppCacheEnabled(true);
//        //设置 缓存模式
////        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
//        // 开启 DOM storage API 功能
////        webView.getSettings().setDomStorageEnabled(true);
//        webView.setWebViewClient(new WebViewClient() {
//            //覆盖shouldOverrideUrlLoading 方法
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
////        webView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//
//        webView.loadUrl("http://www.baidu.com");
//
//    }
//
//
//    @Override
//    protected void onResume() {
//        if (playerView != null) {
//            playerView.onResume();
//            //屏幕重新点亮继续播放
////            loadData(mLiveUrl, mImageUrl);
//            playerView.play(true);
////            floatingActionButton.show(playerView.getFullscreen());
//        }
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        if (playerView != null) {
//            playerView.stop();
//        }
//        super.onPause();
//    }
//
//    @Override
//    protected void onDestroy() {
//        if (playerView != null) {
//            playerView.onDestroy();
//            playerView.onPause();
//            playerView.pause();
//            playerView.stop();
//            playerView = null;
//        }
//        super.onDestroy();
//    }
//}
