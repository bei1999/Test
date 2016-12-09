package com.bei.test.adapter;

/**
 * Created by lzb on 16/12/7.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;
import com.bei.test.bean.NewsCategoryBean;
import com.bei.test.fragment.NewsListFragment;


public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private List<NewsCategoryBean> categoryBeans;


    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void update(List<NewsCategoryBean> data) {
        categoryBeans = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return categoryBeans == null ? 0 : categoryBeans.size();
    }

    @Override
    public Fragment getItem(int position) {
        String template = categoryBeans.get(position).getId()+"";
        return NewsListFragment.newInstance(template);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categoryBeans.get(position).getName();
    }
}