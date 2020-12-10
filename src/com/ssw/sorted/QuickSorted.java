package com.ssw.sorted;

/**
 * 快排
 */
public class QuickSorted {
    //交换
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //分区 分为小于区域大于区域
    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < arr[R]) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > arr[R]) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    //递归分区
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }


    public static void quickSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
}
