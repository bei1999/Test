package com.bei.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.bei.test.R;
import com.bei.test.bean.NewsData;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lzb on 16/12/8.
 */

public class CommandNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private OnClickListener mOnClickListener;
    private List<NewsData> newsDataList;

    public CommandNewsAdapter(Context context) {
        this.mContext = context;
    }

    public CommandNewsAdapter(Context context, List<NewsData> newsDataList) {
        this.mContext = context;
        this.newsDataList = new ArrayList<NewsData>();
        if (newsDataList != null && !newsDataList.isEmpty()) {
            this.newsDataList.addAll(newsDataList);
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.layout_common_news_list, parent, false);
        return new VHNormal(listItem);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHNormal) {
            VHNormal vhNormal = (VHNormal) holder;
            NewsData newsData = getItem(position);
            if (newsData != null) {
                vhNormal.textView2.setText(newsData.getName());
            }
        }

    }

    private NewsData getItem(int position) {
        return newsDataList.get(position);
    }

    @Override
    public int getItemCount() {
        return newsDataList.size();
    }

    class VHNormal extends RecyclerView.ViewHolder implements View.OnClickListener {
//        @Bind(R.id.button2)
//        Button button2;
//        @Bind(R.id.textView2)
//        TextView textView2;
        private Button button02;
        TextView textView2;

        public VHNormal(View itemView) {
            super(itemView);
//            ButterKnife.bind(itemView);
            button02 = (Button) itemView.findViewById(R.id.button2);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
            button02.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnClickListener == null) {
                return;
            }
            //            int position = getAdapterPosition();
            //            if (position == RecyclerView.NO_POSITION) {
            //                return;
            //            }
            //            ProjectTemplateBean bean = getItem(position);
            switch (v.getId()) {
                case R.id.button2:
                    mOnClickListener.onActionLiveClick("xxx");
                    break;
                default:
                    break;
            }
        }
    }

    public interface OnClickListener {
        void onActionLiveClick(String temp);
    }
}
