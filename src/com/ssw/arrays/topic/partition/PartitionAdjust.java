package com.ssw.arrays.topic.partition;

/**
 * 数组的partition调整
 */
public class PartitionAdjust {

    /**
     * 有序数组arr，调整arr使得这个数组左半部分没有重复元素且升序，而不用保证右部分是否升序。
     * <p>
     * 要求时间复杂度O(N),额外空间复杂度O(1)
     */
    public static void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int u = 0;//升序的右边界
        int i = 1;
        while (i != arr.length) {
            if (arr[i] != arr[u]) {
                swap(arr, ++u, i);
            }
            i++;
        }
    }


    /**
     * 补充问题：
     * 给定一个数组arr，其中只可能含有0,1,2三个值，实现arr的排序
     * 另一种问法：有个数组，其中只有红球、蓝球和黄球，请实现红球全放在数组的左面，蓝球放在中间，黄球放在右面
     * 另一种问法：有个数组arr，再给定一个值k，实现比k小的放在数组的左面，等于k的放在中间，大于k的放在右边。
     * <p>
     * 为快排的partition过程
     */

    public static void partition(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur < more) {
            if (arr[cur] == 0) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] == 2) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9};
        leftUnique(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
