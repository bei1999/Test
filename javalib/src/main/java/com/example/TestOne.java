package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lzb on 17/2/17.
 */

public class TestOne {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("lilei", 21));
        studentList.add(new Student("sada", 23));
        studentList.add(new Student("jj", 13));
        studentList.add(new Student("sada", 23));
        studentList.add(new Student("jj", 13));
        studentList.add(new Student("sada", 23));
        studentList.add(new Student("jj", 16));
//
//        removeDuplicate(studentList);
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(4);
//        list.add(2);
//        list.add(6);
//        list.add(9);
//        list.add(3);
//        list.add(7);

    }

//    private static void removeDuplicate(List<Student> list) {
//        for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {
//            for ( int j = list.size() - 1 ; j > i; j -- ) {
//                if (list.get(j).equals(list.get(i))) {
//                    list.remove(j);
//                }
//            }
//        }
//
//        System.out.println(list);
//
//    }

//    public static void removeDuplicate(List list) {
//        HashSet h = new HashSet(list);
//        list.clear();
//        list.addAll(h);
//        System.out.println(list);
//    }


    public static void removeDuplicate(List<Student> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).getName().equals(list.get(i).getName())) {
                    list.remove(j);

                }
            }
        }
        System.out.println(list);
    }
}
