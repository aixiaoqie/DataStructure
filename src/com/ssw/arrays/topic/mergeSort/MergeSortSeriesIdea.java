package com.ssw.arrays.topic.mergeSort;

import static com.ssw.sorted.MergeSorted.merge;

/**
 * 归并排序思想相关问题
 */
public class MergeSortSeriesIdea {
    /**
     * 1. 求数组的小和
     * 在一个数组中，每一个左面的数比当前数小的累加起来,叫做数组的小和，求数组的小和
     * <p>
     * 在归并过程产生数组的小和，求左面的数比当前数小的累加起来的和。
     * 相当于求比当前数大的右面有多少个，若右面有k个数比当前cur数大，则当前数cur共产生cur*k的小和。
     * <p>
     * 2.逆序对问题，一个数组如果左面的数比右面的数大，则这两个数构成一个逆序对，请打印所有逆序对。
     */

    public static int mergeSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;// mid = (l + r) / 2;
        return mergeSort(arr, l, mid)
                + mergeSort(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int sum = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            sum += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;//计算小和
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return sum;
    }
}
