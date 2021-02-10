package com.ssw.string.topic;

/**
 * 翻转字符串
 */
public class OverturnString {
    /**
     * 给定一个字符类型的数组chas，做单词间的逆序调整，只需要做到单词逆序即可，空格位置无要求。
     * <p>
     * 例如：如果把数组看作字符串"dog loves pig",调整成"pig loves dog";如果把数组看作字符串"I'm a pig.",调整成"pig. a I'm"
     * <p>
     * 要求时间复杂度为O(N),额外空间复杂度为O(1).
     * <p>
     * 解法：首先把chas整体逆序。在逆序之后找到每个单词，然后把每个单词里的字符逆序即可。
     */


    public static void rotate(char[] chas) {
        if (chas == null || chas.length < 2) {
            return;
        }
        reverse(chas, 0, chas.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < chas.length - 1; i++) {
            if (chas[i] != ' ') {
                l = i == 0 || chas[i - 1] == ' ' ? i : l;//记录单词左面位置
                r = i == chas.length - 1 || chas[i + 1] == ' ' ? i : r;//记录单词右面位置
            }
            if (l != -1 && r != -1) {
                reverse(chas, l, r);
                l = -1;
                r = -1;
            }
        }
    }


    public static void reverse(char[] arr, int left, int right) {
        char tmp = 0;
        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }


    /**
     * 补充问题：给定一个字符类型的数组chas和一个整数size,请把大小为size的左半区整体移动到右半区,右半区移动到左半区。
     * <p>
     * 举例：如果把字符数组看作字符串"ABCDE",size为3，调整为"DEABC".
     * <p>
     * 要求时间复杂度为O(N),额外空间复杂度为O(1).
     * <p>
     * 解法：方法1.先将chas[0...size-1]逆序，再将chas[size....length-1]逆序，最后再将chas整体逆序
     */
    public static void rotate1(char[] chas, int size) {
        if (chas == null || chas.length < 2) {
            return;
        }
        reverse(chas, 0, size - 1);
        reverse(chas, size, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
    }
    /**
     * 方法2：
     */
// TODO: 2021/1/8 方法2实现 
}
