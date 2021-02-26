package com.ssw.arrays.topic.binarysearch;

/**
 * 在两个长度相等的排序数组中找到上中位数
 * <p>
 * 例如 arr1=[1,2,3,4],arr2=[3,4,5,6],总共有8个数，上中位数是第4小的数，所以返回3。
 * 例如 arr1=[0,1,2],arr=[3,4,5],总共6个数，上中位数是第3小的数，所以返回2。
 * <p>
 * 要求：额外空间复杂度O(1),时间复杂度O(logN)
 */
public class GetUpMedian {
    public static int getUpMedian(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new RuntimeException("parameter is invalid");
        }
        int start1 = 0;
        int end1 = arr1.length - 1;
        int start2 = 0;
        int end2 = arr2.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (start1 < end1) {
            mid1 = (start1 + end1) / 2;
            mid2 = (start2 + end2) / 2;
            offset = (end1 - start1 + 1) % 2 == 0 ? 1 : 0;//偶数offset为1 奇数为0
            if (arr1[mid1] > arr2[mid2]) {
                end1 = mid1;
                start2 = mid2 + offset;
            } else if (arr1[mid1] < arr2[mid2]) {
                end2 = mid2;
                start1 = mid1 + offset;
            } else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[start1], arr2[start2]);

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        int[] arr3 = {0, 1, 2};
        int[] arr4 = {3, 4, 5};
        int[] arr5 = {0, 1, 2};
        int[] arr6 = {3, 4, 5};
        System.out.println(getUpMedian(arr1, arr2));
        System.out.println(getUpMedian(arr3, arr4));
    }
}
