package src.com.ssw.sorted;

import static src.com.ssw.sorted.QuickSorted.*;

public class TestSorted {

    public static void main(String[] args) {
        int[] a = {1, 4, 8, 5, 3};
        quickSort(a, 0, a.length - 1);
    }
}
