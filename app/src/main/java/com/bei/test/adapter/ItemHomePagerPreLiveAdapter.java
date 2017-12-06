package com.bei.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bei.test.MyApplication;
import com.bei.test.R;
import com.bei.test.bean.NewsData;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class ItemHomePagerPreLiveAdapter extends BaseAdapter {

    private List<NewsData> objects = new ArrayList<NewsData>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ItemHomePagerPreLiveAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    public void update(List<NewsData> newsDataListBeanList) {
        this.objects = newsDataListBeanList;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public NewsData getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_home_pager_pre_live, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((NewsData)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(NewsData preLiveListBean, ViewHolder holder) {
        //TODO implement
        if (preLiveListBean != null) {
            String preLiveImgUrl = "https://liveapptest.cgtn.com/data/d1/uploads/images/2017/04/19/8IWB72LT4Y.jpg";
            Glide.with(MyApplication.getContext()).load(preLiveImgUrl)
                    .centerCrop()
                    .into(holder.preLiveIv);
            holder.showTv.setText(preLiveListBean.getName());
        }
    }

    protected class ViewHolder {
        private RelativeLayout mainLl;
        private ImageView preLiveIv;
        private ImageView liveForshowShare;
        private TextView showTv;

        public ViewHolder(View view) {
            mainLl = (RelativeLayout) view.findViewById(R.id.main_ll);
            preLiveIv = (ImageView) view.findViewById(R.id.pre_live_iv);
            liveForshowShare = (ImageView) view.findViewById(R.id.live_forshow_share);
            showTv = (TextView) view.findViewById(R.id.show_tv);
        }
    }
}
