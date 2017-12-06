package com.example.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lzb on 17/2/19.
 */

public class BubbleSortTest02 {
    public static void main(String[] args) {
//        int[] data = new int[]{1, 4, 2, 2,2,2,2,2,2,2,26, 9, 3, 7};
////        bubbleSort01(data);
//        List<String> stringList = new ArrayList<>();
//        stringList.add()
//        bubbleSort02(data);

        String[] userid = {"1", "4","2","25", "7", "2","90"};
        List<String> userList = Arrays.asList(userid);
        bubbleSort01(userList);

        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }

    }

    //小的元素向下移（气泡的下沉)
    public static void bubbleSort01(List<String> data) {
        for (int i = 0; i < data.size() - 1; i++) {
//            System.out.println("第" + i + "次循环");
//            int temp = 0;
            for (int j = i + 1; j < data.size(); j++) {
//                System.out.println("i,j" + "===" + i + "," + j);
                if (data.get(i).equals(data.get(j))) {
                    data.remove(i);
//                    i --;
                }
            }

        }

    }

    //大的元素向上移（气泡的上浮)
    public static void bubbleSort02(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            System.out.println("第" + i + "次循环");
            int temp = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                System.out.println("j,j+1" + "===" + j + "," + (j + 1));
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(data));

        }
    }
}
