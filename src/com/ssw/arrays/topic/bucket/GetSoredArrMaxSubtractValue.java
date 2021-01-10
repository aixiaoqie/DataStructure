package com.ssw.arrays.topic.bucket;

/**
 * 数组排序之后相邻两数的最大差值
 * <p>
 * 问题：给定一个整型数组arr，求如果排序之后，相邻两数的最大差值。
 * <p>
 * 举例： arr = [1,2,3,6,7],返回3 ; arr = [5,5,5,5],返回0
 * <p>
 * 要求：时间复杂度为O(N)
 */
public class GetSoredArrMaxSubtractValue {

    /**
     * 分析：如果使用排序法实现，可以做到时间复杂度为O(N*LogN)
     * <p>
     * 如果利用桶排序的思想(并不直接进行桶排序，而是借用桶这个容器)，可以做到时间复杂度O(N),额外空间复杂度O(N)
     */
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        if (min == max) {
            return 0;
        }
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];//记录上一个非空桶的最大值
        for (int i = 1; i <= len; i++) {//遍历辅助的三个数组 maxs mins hasNum
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 将数组中任意一个数放到对应的桶中。
     *
     * @param num 数组中任意一个数的值
     * @param len 数组的长度
     * @param min 数组中最小值
     * @param max 数组中最大值
     * @return
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6, 7};
        int i = maxGap(arr);
        System.out.println(i);
    }
}
