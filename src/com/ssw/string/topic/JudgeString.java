package com.ssw.string.topic;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个字符串相互比较的一些操作
 */
public class JudgeString {

    /**
     * 判断两个字符串是否互为变形词
     * <p>
     * 给定两个字符串str1 str2，如果str1和str2出现的字符种类一样且每种字符出现的次数也一样，那么两个字符串互为变形词
     * <p>
     * 如果字符串总数为N,字符种类为M,则时间复杂度为O(N),额外空间复杂度为O(M)
     */

    public static boolean isInflection(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() != str1.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();

        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        for (int i = 0; i < charArr1.length; i++) {
            if (map.get(charArr1[i]) != null) {
                map.put(charArr1[i], map.get(charArr1[i]) + 1);
            } else {
                map.put(charArr1[i], 1);
            }
        }
        for (int i = 0; i < charArr2.length; i++) {
            if (map.get(charArr2[i]) != null) {
                map.put(charArr2[i], map.get(charArr2[i]) - 1);
                if (map.get(charArr2[i]) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        String s1 = "12345";
        String s2 = "543211";
        boolean inflection = isInflection(s1, s2);
        System.out.println(inflection);
    }
}
