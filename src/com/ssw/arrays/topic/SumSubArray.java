package com.ssw.arrays.topic;

/**
 * 子数组累加和问题
 * <p>
 * 题目：给定一个数组arr，返回子数组的最大累加和
 * <p>
 * 例如arr=[1,-2,3,5,-2,6.-1],所有的子数组中，[3,5,-2,6]可以累加出最大的和为12，所以返回12
 * <p>
 * 要求：时间复杂度O(N),额外空间复杂度O(1).
 * <p>
 * sum记录子数组累加和，如果累加成负数就清零重新累加，max记录sum的最大值
 */
public class SumSubArray {
    public static int getSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    }

    /**
     * 子矩阵的最大累加和问题
     * <p>
     * 给定一个矩阵matrix，其中有正负0，返回子矩阵的最大累加和。
     * <p>
     * 时间复杂度O(N^3)
     */

    public static int getMatrixSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] s = null;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            s = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                sum = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += matrix[j][k];
                    sum += s[k];
                    max = Math.max(max, sum);
                    sum = sum < 0 ? 0 : sum;
                }
            }
        }
        return max;
    }


}
