package com.ssw.arrays.topic;

public class MinSubArray {

    /**
     * 求需要排序的最短子数组长度
     * <p>
     * 给定一个无序数组，求出需要排序的最短子数组长度
     * 例如： arr=[1,5,3,4,2,6,7],返回4 ,只有[5,3,4,2]需要排序
     * <p>
     * 时间复杂度O(N),额外空间复杂度O(1)
     */
    public static int getMinLen(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int noMinIndex = -1;//用于记录数组中大于右侧最小值左边界
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(arr[i], min);
            }
        }
        if (noMinIndex == -1) {//说明原数组从小到大有序
            return 0;
        }
        int max = arr[0];
        int noMaxIndex = -1;//用于记录数组中小于左侧最大值的右边界
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(arr[i], max);
            }
        }
        return noMaxIndex - noMinIndex + 1;

    }

    public static void main(String[] args) {
        int[] data = new int[]{5, 4, 3, 2, 1};
        System.out.println(getMinLen(data));
    }
}
