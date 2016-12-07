package com.bei.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bei.test.R;
import com.bei.test.adapter.HomePagerAdapter;
import com.bei.test.bean.NewsCategoryBean;
import com.bei.test.view.tab.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzb on 16/12/7.
 */

public class HomeFragment extends BaseFragment {
    private ViewPager viewPager;
    private HomePagerAdapter pagerAdapter;
    private PagerSlidingTabStrip slidingTabStrip;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        pagerAdapter = new HomePagerAdapter(getChildFragmentManager());
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter);
        slidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.slidingTabs);
        slidingTabStrip.setViewPager(viewPager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadTemplate();
    }

    private void loadTemplate() {
        List<NewsCategoryBean> categoryBeanList = new ArrayList<NewsCategoryBean>();
        categoryBeanList.add(new NewsCategoryBean(1, "one"));
        categoryBeanList.add(new NewsCategoryBean(2, "two"));
        categoryBeanList.add(new NewsCategoryBean(3, "tree"));
        pagerAdapter.update(categoryBeanList);

    }
}

