package com.ssw.arrays.topic;

/**
 * 自然数数组的排序
 * <p>
 * 题目：给定一个长度为N的整型数组arr，其中有N个互不相等的自然数1~N,请实现arr的排序，但不要把下标0~N-1位置上的数直接通过赋值的方式替换
 * <p>
 * 要求：时间复杂度O(1),额外空间复杂度O(1).
 */
public class NaturalNumSort {
    public static void sort2(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 3};
        sort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
