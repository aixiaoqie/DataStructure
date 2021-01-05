package com.ssw.string.topic;

/**
 * 替换字符串中连续出现的指定字符串
 * <p>
 * 给定3个字符串str,from,to, 把str中所有的from子串全部替换成to字符串，如果连续出现的from替换成一个to字符串
 */
public class ReplaceString {

    public String replace(String str, String from, String to) {
        if (str == null || str.equals("") || from == null || from.equals("")) {
            return str;
        }
        char[] strArr = str.toCharArray();
        char[] fromArr = from.toCharArray();
        int match = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == fromArr[match++]) {
                if (match == fromArr.length) {
                    clear(strArr, i, match);//match是from的最后一个字符，清除str字符串中以i为结尾，前match个位置的字符。
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != 0) {
                cur = cur + String.valueOf(strArr[i]);
            }
            if (strArr[i] == 0 && (i == 0 || strArr[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if (!cur.equals("")) {
            res += cur;
        }
        return res;

    }

    private void clear(char[] strArr, int end, int length) {
        while (length-- != 0) {
            strArr[end--] = 0;
        }
    }

    public static void main(String[] args) {
        String str = "123abc";
        String from = "123";
        String to ="ABC";
        String replace = new ReplaceString().replace(str, from, to);
        System.out.println(replace);
    }
}
