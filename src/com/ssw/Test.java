package com.ssw;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {

        char[] arr = new char[]{'a', 'b', 'c'};
        System.out.println(arr);
//        String s = "rat";
//        String t = "tar";
//        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        String s1 = String.valueOf(sArr);
        String s2 = String.valueOf(tArr);
        return s1.equals(s2);
    }
}
