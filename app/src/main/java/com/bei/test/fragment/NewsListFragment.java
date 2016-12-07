package com.bei.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bei.test.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzb on 16/12/7.
 */
public class NewsListFragment extends BaseFragment {
    private static final String EXTRA_TEMPLATE = "template";
    private String template;
    @Bind(R.id.text)
    TextView text;


    public static NewsListFragment newInstance(String template) {
        Bundle args = new Bundle();
        args.putString(EXTRA_TEMPLATE, template);
        NewsListFragment fragment = new NewsListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        template = getArguments().getString(EXTRA_TEMPLATE);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        text.setText(template);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
