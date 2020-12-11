package com.ssw.sorted;


import src.com.ssw.sorted.HeapSorted;

public class TestSorted {

    public static void main(String[] args) {
        int[] a = {1, 4, 8, 5, 3, 9, 5, 3, 3};
//        QuickSorted.quickSorted(a);
//        BubbleSorted.bubbleSorted2(
//        a);
//        InsertSorted.insertSorted(a);
//        SelectSorted.selectSorted(a);
        HeapSorted.heapSorted(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
