package com.ssw.string.topic;

/**
 * 判断字符数组中是否所有的字符都只出现一次
 * 例如chas=['a','b','c'],返回true；chas=['1','2','1'],返回false
 * <p>
 * 1.使时间复杂度为O(N)
 * 2.在保证空间复杂度为O(1)的情况下，实现时间复杂度尽量低的方法。
 */
public class JudgeCharArr {

    /**
     * 要求1. 遍历一遍字符数组，用map记录每种字符出现情况，map可以用长度固定的数组实现，或者使用哈希表实现。
     */

    public static boolean isUnique(char[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        boolean[] map = new boolean[256];//map存储ASCII 编码，用于记录每个字符出现情况
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + 0);
            if (map[arr[i]]) {
                return false;
            }
            map[arr[i]] = true;
        }
        return true;
    }

    /**
     * 要求2 ：分析
     * 整体思路先将字符数组排序，排序后相同的字符就放在一起，然后判断有没有重复字符就会很容易。
     * 所以问题关键是选择什么排序：
     * 1. 首先时间复杂度为O(N)的排序算法无论如何都做不到额外空间复杂度为O(1),
     * 因为这些算法不是基于比较的算法，有多少数都要装下，然后按照一定顺序倒出完成排序，所以桶排序，基数排序，计数排序排除。
     * 2. 然后看时间复杂度为O(N*logN)的排序，有归并排序、快排、堆排以及希尔排序。
     * 归并排序首先被排除，因为归并有两个小数组合成大数组的过程，这个过程需要辅助数组才能完成，尽管可以通过手摇算法将额外空间复杂度降到O(1)，但这样最差情况下时间复杂度会上升到O(N`2);
     * 快速排序也被排除，因为无论递归还是非递归实现，快速排序的额外空间复杂度最低为O(N*logN),无法到达O(1).
     * 希尔排序也被排除，因为希尔排序的时间复杂度不固定，成败完全在于步长的选择，如果选择不当，时间复杂度会变为O(N`2)。
     * 所以这四种经典排序中只有堆排符合，但递归实现的堆排序会使用栈空间，这样额外空间复杂度会增加为O(logN)。
     * 因此，选择非递归实现的堆排。
     */

    public static boolean isUnique2(char[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        heapSorted(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapInsert(char[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(char[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = arr[left] < arr[left + 1] && left + 1 < size ? left + 1 : left;
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapSorted(char[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i != arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void main(String[] args) {
        char[] arr = {'1', '2', '4', '6', 'p'};
        boolean unique2 = isUnique(arr);
        System.out.println(unique2);
    }
}
