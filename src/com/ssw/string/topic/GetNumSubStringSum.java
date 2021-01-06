package com.ssw.string.topic;

public class GetNumSubStringSum {
    /**
     * 获取字符串中数字子串的和
     * 前面一个-表示负数，--表示正数
     */

    public static int getMax(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        int res = 0;
        int num = 0;
        int cur = 0;
        boolean pos = true;//是否为正数
        for (int i = 0; i < arr.length; i++) {
            cur = arr[i] - '0';
            if (cur < 0 || cur > 9) { //当前位置的字符不是数字
                res += num;
                num = 0;
                if (arr[i] == '-') {
                    if (i - 1 > -1 && arr[i - 1] == '-') {
                        pos = !pos;
                    } else {
                        pos = false;
                    }
                } else {
                    pos = true;
                }
            } else {
                num = num * 10 + (pos ? cur : -cur);
            }
        }
        res += num;
        return res;

    }

    public static void main(String[] args) {
        String str = "A-1B--2C7";
        int max = getMax(str);
        System.out.println(max);
    }
}
