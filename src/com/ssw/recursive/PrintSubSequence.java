package com.ssw.recursive;

/**
 * 打印一个字符串的全部子序列，包括空字符串
 */
public class PrintSubSequence {

    /**
     * 打印一个字符串的全部子序列，包括空字符串
     */
    public static void printAllSub(String str) {
        char[] array = str.toCharArray();
        process(array, 0, "");
    }

    /**
     * i表示当前字符，res表示 0 ~ i-1 形成的序列
     */
    public static void process(char[] arr, int i, String res) {
        if (i == arr.length) {
            System.out.println(res);
            return;
        }
        process(arr, i + 1, res);  //不要当前字符
        process(arr, i + 1, res + arr[i]);//要当前字符
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test);
    }
}
