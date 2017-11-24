package com.bei.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bei.test.adapter.ItemHomePagerPreLiveAdapter;
import com.bei.test.bean.NewsData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/04/21
 * desc   : test recyclerview add header
 * version: 1.0
 */
public class MainActivity08 extends Activity {
    @Bind(R.id.testListView)
    ListView testListView;

    ListView headerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main08);
        ButterKnife.bind(this);
        ItemHomePagerPreLiveAdapter itemHomePagerPreLiveAdapter = new ItemHomePagerPreLiveAdapter(this);
        List<NewsData> newsDataList = new ArrayList<NewsData>();
        newsDataList.add(new NewsData(1, "body item01"));
        newsDataList.add(new NewsData(1, "body item02"));
        itemHomePagerPreLiveAdapter.update(newsDataList);
        testListView.setAdapter(itemHomePagerPreLiveAdapter);

        View headView = View.inflate(this, R.layout.main_home_head, null);
        headerListView = (ListView) headView.findViewById(R.id.headerListView);

        List<NewsData> headerNewsDataList02 = new ArrayList<NewsData>();
        headerNewsDataList02.add(new NewsData(3, "header item01"));
        headerNewsDataList02.add(new NewsData(4, "header item02"));
        ItemHomePagerPreLiveAdapter itemHomePagerPreLiveAdapter02 = new ItemHomePagerPreLiveAdapter(this);

        itemHomePagerPreLiveAdapter02.update(headerNewsDataList02);
        headerListView.setAdapter(itemHomePagerPreLiveAdapter02);

        testListView.addHeaderView(headView);
    }
}
