package com.ssw.sorted;



import java.util.Stack;

public class TestSorted {

    public static void main(String[] args) {
        int[] a = {1, 4, 8, 5, 3, 9, 5, 3, 3};
//        QuickSorted.quickSorted(a);
//        BubbleSorted.bubbleSorted2(
//        a);
//        InsertSorted.insertSorted(a);
//        SelectSorted.selectSorted(a);
//        HeapSorted.heapSorted(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }


        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.peek());
    }

}
