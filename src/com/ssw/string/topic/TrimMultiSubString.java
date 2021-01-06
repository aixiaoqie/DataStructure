package com.ssw.string.topic;


/**
 * 去除字符串中连续出现k个0的字串
 */
public class TrimMultiSubString {

    public static String remove(String str, int k) {
        if (str == null || k < 2) {
            return str;
        }
        char[] arr = str.toCharArray();
        int count = 0;//全局变量，用于记录出现0的次数
        int start = -1;//全局变量，用于记录0开始的位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        arr[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0) {
                arr[start++] = 0;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "A00B0004000";
        String remove = remove(s, 3);
        System.out.println(remove);
    }
}
