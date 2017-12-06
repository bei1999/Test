package com.example.sort;

import java.util.Arrays;

/**
 * Created by lzb on 17/2/19.
 */

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] data = new int[]{1, 4, 2, 2,2,2,2,2,2,2,26, 9, 3, 7};
//        bubbleSort01(data);
//        bubbleSort02(data);

    }

    //小的元素向下移（气泡的下沉)
    public static void bubbleSort01(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            System.out.println("第" + i + "次循环");
            int temp = 0;
            for (int j = i + 1; j < data.length; j++) {
                System.out.println("i,j" + "===" + i + "," + j);
                if (data[i] > data[j]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
            System.out.println(Arrays.toString(data));

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
