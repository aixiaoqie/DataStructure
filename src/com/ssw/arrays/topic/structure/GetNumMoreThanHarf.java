package com.ssw.arrays.topic.structure;

/**
 * 在数组中找到出现次数大于N/K的数
 * <p>
 * 解题思路：一次在数组中删掉K个不同的数，不停的删除，知道剩下数的种类不足K就停止删除。
 * 那么，如果一个数在数组中出现的次数大于N/K,则这个数最后一定会被剩下来。
 */
public class GetNumMoreThanHarf {

    /**
     * 题目：给定一个整型数组arr,打印其中出现次数大于一半的数，如果没有这样的数，打印提示信息
     * <p>
     * 要求：时间复杂度O(N),额外空间复杂度O(1).
     * <p>
     * 解题思路：出现次数大于一半的数最多只有一个，或者不存在。具体过程为：
     * 一次在数组中删掉两个不同的数，不停的删除直到剩下的数只有一种。如果一个数出现的次数大于一半，那么这个数最后一定会剩下来。
     * Major [ˈmeɪdʒər]   较多的
     */
    public void printHalfMajor(int[] arr) {
        int candidate = 0; //候选
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (times == 0) {
                candidate = arr[i];
            } else if (candidate == arr[i]) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (candidate == arr[i]) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println(candidate);
        } else {
            System.out.println("no such number");
        }
    }

    public static void main(String[] args) {
        GetNumMoreThanHarf harf = new GetNumMoreThanHarf();
        int[] arr = new int[]{1, 2, 3, 4, 2, 2, 2};
        harf.printHalfMajor(arr);
    }
}
