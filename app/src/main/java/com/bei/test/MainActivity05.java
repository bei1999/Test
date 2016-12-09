package com.bei.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bei.test.adapter.CommandNewsAdapter;
import com.bei.test.bean.NewsData;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by lzb on 16/12/8.
 * test RecyclerView
 */

public class MainActivity05 extends Activity {
    private Context mContext;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<NewsData> mNewsDataList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main05);
        this.mContext = MainActivity05.this;
        ButterKnife.bind(this);
        initData();
        initViews();

    }

    private void initData() {
        mNewsDataList = new ArrayList<NewsData>();
        NewsData newsData1 = new NewsData(1, "aaa");
        NewsData newsData2 = new NewsData(2, "bbbb");
        NewsData newsData3 = new NewsData(3, "cccc");
        mNewsDataList.add(newsData1);
        mNewsDataList.add(newsData2);
        mNewsDataList.add(newsData3);
    }

    private void initViews() {
        CommandNewsAdapter commandNewsAdapter = new CommandNewsAdapter(mContext, mNewsDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(commandNewsAdapter);
        commandNewsAdapter.setOnClickListener(new CommandNewsAdapter.OnClickListener() {
            @Override
            public void onActionLiveClick(String temp) {
                Logger.d(temp);
            }
        });

    }


}
