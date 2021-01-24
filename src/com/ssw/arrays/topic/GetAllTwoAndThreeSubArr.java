package com.ssw.arrays.topic;

/**
 * 不重复打印排序数组中相加和为给定值的所有二元组和三元组
 */
public class GetAllTwoAndThreeSubArr {

    /**
     * 题目：给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组
     * <p>
     * 例如arr=[-8,-4,-3,0,1,2,3,4,5,8,9] , k=10 。 打印结果为 1,9  2,8
     * <p>
     * 解：利用排序后的数组特点，打印二元组可以使用一个左指针和右指针不断想中间压缩的方式。
     * 不打印重复的再加个检查即可，检查当前值是否与前一个值相等，相等就不打印
     * <p>
     * 时间复杂度为O(N)
     */

    public static void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == k) {
                if (left == 0 || arr[left] != arr[left - 1]) {
                    System.out.println(arr[left] + "," + arr[right]);
                }
                left++;
                right--;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                left++;
            }
        }
    }


    /**
     * 进阶问题：给定排序数组arr和整数k，不重复打印arr中所有相加为k的三元组
     * <p>
     * 时间复杂度为O(N^2)
     */
    public static void printUniqueTriad(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                printRest(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }
    }

    private static void printRest(int[] arr, int f, int l, int r, int k) {
        while (l < r) {
            if (arr[l] + arr[r] > k) {
                r--;
            } else if (arr[l] + arr[r] < k) {
                l++;
            } else {
                if (l == f + 1 || arr[l] != arr[l - 1]) {
                    System.out.println(arr[f] + "," + arr[l] + "," + arr[r]);
                }
                r--;
                l++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        printUniquePair(arr, 10);
        printUniqueTriad(arr, 10);
    }
}
