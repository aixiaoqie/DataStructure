package com.ssw.sorted;



public class TestSorted {

    public static void main(String[] args) {
        int[] a = {1, 4, 8, 5, 3};
//        quickSort(a, 0, a.length - 1);
//        BubbleSorted.bubbleSorted2(a);
//        InsertSorted.insertSorted(a);
        SelectSorted.selectSorted(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
