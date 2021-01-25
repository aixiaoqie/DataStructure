package com.ssw.arrays.topic;

/**
 * 数组下标调整相关问题
 */
public class ArrIndexAdjust {

    /**
     * 奇数下标都是偶数或者偶数下标都是奇数
     * <p>
     * 题目：给定一个长度大于2的数组，实现一个函数，要么让所有的偶数下标都是偶数或者所有奇数下标都是奇数
     * <p>
     * 要求：时间复杂度O(N)，额外空间复杂度O(1)
     * <p>
     * 数组最后面的数为偶数与偶数下标交换，奇数就与奇数下标交换。
     */
    public static void adjust(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int even = 0;
        int odd = 1;
        int end = arr.length - 1;
        while (even <= end && odd <= end) {
            if ((arr[even] & 1) == 0) { //位运算，二进制位数最低为1或者0，所以1为奇数，2为偶数
                swap(arr, even, end);
                even += 2;
            } else {
                swap(arr, odd, end);
                odd += 2;
            }
        }

    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
