package com.ssw.recursive;


/**
 * 打印一个字符串的全排列
 * <p>
 * 进阶：要求不要有重复的排列
 */
public class PrintAllPermutation {

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 考虑把复杂的问题分解成小的问题。
     * 比如，把一个字符串看成由两部分组成：第一部分是它的第一个字符；第二部分是后面的所有字符。
     * 而我们求整个字符串的排列，可以看成两步。
     * 第一步求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换（这里有点全排列的意思）。
     * 第二步是固定第一个字符，求后面所有字符的排列。这时候我们仍把后面的所有字符分成两个部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符和它后面的所有字符交换。
     */
    public static void process(char[] arr, int i) {
        if (i == arr.length) {
            System.out.println(arr); //base case 打印排列后的字符数组
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            process(arr, i + 1);
            swap(arr, i, j);
        }
    }

    public static void PrintAllPermutation(String str) {
        char[] array = str.toCharArray();
        process(array, 0);
    }

    public static void main(String[] args) {
        PrintAllPermutation("abc");
        PrintAllPermutation("abc");
    }

}
