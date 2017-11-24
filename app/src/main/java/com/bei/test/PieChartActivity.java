package com.bei.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bei.test.bean.PieChartBean;
import com.bei.test.widget.PieChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/11/24
 * desc   :
 * version: 1.0
 */
public class PieChartActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);

        PieChartView pieChartView = (PieChartView) findViewById(R.id.piechart_view);

        List<PieChartBean> pieChartBeans = new ArrayList<PieChartBean>();
        pieChartBeans.add(new PieChartBean("aa",70));
        pieChartBeans.add(new PieChartBean("aa",15));
        pieChartBeans.add(new PieChartBean("aa",10));
        pieChartBeans.add(new PieChartBean("aa",5));


        pieChartView.setStartAngle(30);
        pieChartView.setData(pieChartBeans);


    }
}
