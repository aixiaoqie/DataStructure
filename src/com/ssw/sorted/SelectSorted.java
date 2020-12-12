package com.ssw.sorted;

/**
 * 选择排序（小->大）
 */
public class SelectSorted {

    public static void selectSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex; //每次只排好第一个位置
            }
            swap(arr, minIndex, i);
        }
    }


    //交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
