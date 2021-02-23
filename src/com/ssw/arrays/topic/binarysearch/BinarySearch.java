package com.ssw.arrays.topic.binarysearch;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int key, int l, int r) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = binarySearch(arr, 4, 0, arr.length - 1);
        System.out.println(i);
    }
}
