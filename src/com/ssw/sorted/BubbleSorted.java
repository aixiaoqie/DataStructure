package com.ssw.sorted;

/**
 * 冒泡排序
 */
public class BubbleSorted {

    public static void bubbleSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //外层循环，层数
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) { //里层循环，交换次数
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSorted2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //外层循环，层数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) { //里层循环，交换次数
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
