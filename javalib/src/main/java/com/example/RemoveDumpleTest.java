package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * author : lzb
 * e-mail : lizhanbei@cgtn.com
 * time   : 2017/08/16
 * desc   :
 * version: 1.0
 */
public class RemoveDumpleTest {

    public static void main(String[] args) {
        List<LatestNormalNewsListBean> normalNewsMetaDataList = new ArrayList<>();
        LatestNormalNewsListBean latestNormalNewsListBean = new LatestNormalNewsListBean();
        latestNormalNewsListBean.setId("1");
        latestNormalNewsListBean.setHeadline("aaaaaa");
        LatestNormalNewsListBean latestNormalNewsListBean02 = new LatestNormalNewsListBean();
        latestNormalNewsListBean02.setId("2");
        latestNormalNewsListBean02.setHeadline("bbbbbbbb");
        LatestNormalNewsListBean latestNormalNewsListBean03 = new LatestNormalNewsListBean();
        latestNormalNewsListBean03.setId("3");
        latestNormalNewsListBean03.setHeadline("cccccc");
        LatestNormalNewsListBean latestNormalNewsListBean04 = new LatestNormalNewsListBean();
        latestNormalNewsListBean04.setId("4");
        latestNormalNewsListBean04.setHeadline("dddddd");
        LatestNormalNewsListBean latestNormalNewsListBean05 = new LatestNormalNewsListBean();
        latestNormalNewsListBean05.setId("1");
        latestNormalNewsListBean05.setHeadline("xxxxx");
        LatestNormalNewsListBean latestNormalNewsListBean06 = new LatestNormalNewsListBean();
        latestNormalNewsListBean06.setId("1");
        latestNormalNewsListBean06.setHeadline("kkkkk");

        normalNewsMetaDataList.add(latestNormalNewsListBean03);
        normalNewsMetaDataList.add(latestNormalNewsListBean04);
        normalNewsMetaDataList.add(latestNormalNewsListBean05);
        normalNewsMetaDataList.add(latestNormalNewsListBean);
        normalNewsMetaDataList.add(latestNormalNewsListBean02);
        normalNewsMetaDataList.add(latestNormalNewsListBean06);


        distinct(normalNewsMetaDataList);

        for (LatestNormalNewsListBean normalNewsListBean : normalNewsMetaDataList) {
            System.out.println(normalNewsListBean.getId()+"="+normalNewsListBean.getHeadline());
        }

    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }



    public static void distinct( List<LatestNormalNewsListBean> normalNewsMetaDataList) {
        for (int i = 0; i < normalNewsMetaDataList.size() - 1; i++) {
            System.out.println("第" + i + "次循环");
            for (int j = i + 1; j < normalNewsMetaDataList.size(); j++) {
                System.out.println("i,j" + "===" + i + "," + j);
                if (normalNewsMetaDataList.get(i).getId().equals(normalNewsMetaDataList.get(j).getId())) {
                    normalNewsMetaDataList.remove(i);
                    i--;
                }

            }
        }

    }

}
