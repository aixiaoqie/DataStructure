package com.ssw.arrays.topic.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 进阶问题：给定一个整型数组arr，在给定一个整数k，打印所有出现次数大于N/k的数，如果没有这样的数，打印提示信息。
     * <p>
     * 要求：时间复杂度O(N*K),额外空间复杂度O(K).
     * <p>
     * 解题思路：用 k-1个候选，然后 k-1个times
     * 遍历到arr[i]时，看arr[i]是否与已经被选出的某一个候选相同：
     * 1.如果相同，把当前候选点数加1；
     * 2.如果与所有的候选都不同，先看当前的候选是否满了，k-1就是满，否则就是不满：
     * 2.1如果不满，把arr[i]作为一个新的候选，属于他的点数初始化为1.
     * 2.2如果已满，说明此时发现了k个不同的数，arr[i]就是第k个，此时把每一个候选各自的点数全部减一，表示每个候选付出一个自己的点数。
     * 如果某些候选的点数在减1之后等于0，把这些候选删除，候选又变成不满的状态。
     */
    public void printKMajor(int[] arr, int k) {
        if (k < 2) {
            System.out.println("k is invalid");
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                if (hashMap.size() == k - 1) {
                    allCandsAdjust(hashMap);
                } else {
                    hashMap.put(arr[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(arr, hashMap);
        boolean isPrint = false;
        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (reals.get(set.getKey()) > arr.length / k) {
                isPrint = true;
                System.out.println(set.getKey() + " ");
            }
        }
        System.out.println(isPrint ? "" : "no such number");
    }

    //k-1个候选已满的调整操作，每一个候选各自的点数减一，减一之后变为0，把候选删除
    public void allCandsAdjust(HashMap<Integer, Integer> map) {
        List<Integer> removeList = new ArrayList<>();//减到1需要记录需要删除的候选节点
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            int key = set.getKey();
            int value = set.getValue();
            if (value == 1) {
                removeList.add(key);
            }
            map.put(key, value - 1);
        }
        for (Integer removeKey : removeList) {
            map.remove(removeKey);
        }

    }

    /**
     * 统计候选节点每个节点出现的频次
     */
    public HashMap<Integer, Integer> getReals(int[] arr, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curNum = arr[i];
            if (cands.containsKey(curNum)) {
                if (reals.containsKey(curNum)) {
                    reals.put(curNum, reals.get(curNum) + 1);
                } else {
                    reals.put(curNum, 1);
                }
            }
        }
        return reals;
    }

    public static void main(String[] args) {
        GetNumMoreThanHarf harf = new GetNumMoreThanHarf();
        int[] arr = new int[]{3, 2, 3, 3, 2, 2, 2};
        harf.printKMajor(arr, 3);
    }
}
