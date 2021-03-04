package com.ssw.arrays.topic.heap;

import java.util.PriorityQueue;

/**
 * 找到无序数组最小的k个数
 * <p>
 * 若数组的规模为N
 * 解法1 ：将数组排序，在找最小的k个数 ，此时时间复杂度O(N*logN)
 * 解法2 : 使用堆结构，保存需要的k个数，此时时间复杂度为O(N*logK)
 * 解法3 ：BFPRT算法，时间复杂度O(N)
 */
public class TopK {

    public static int[] getTopKByBFPRT(int[] arr, int k) {
        if (k < 1 || k > arr.length || arr == null) {
            return arr;
        }
// TODO: 2021/2/9  BFPRT算法
        return null;
    }


    public static int[] getK(int[] arr, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            } else {
                if (arr[i] < heap.peek()) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (heap.size() > 0) {
            res[index++] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 2, 3, 14, 5, 16, 17, 8, 19, 10};
        int[] k = getK(data, 5);
        for (int i = 0; i < k.length; i++) {
            System.out.println(k[i]);
        }
    }
}
