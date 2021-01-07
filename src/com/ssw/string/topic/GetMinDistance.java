package com.ssw.string.topic;

import java.util.HashMap;

/**
 * 字符串数组中两个字符串的最小距离
 * <p>
 * 给定一个字符串数组strs,在给定2个字符串str1,str2。返回str1,str2在数组中的最小距离，如果str1，str2为null，或者不在数组中返回-1。
 */
public class GetMinDistance {

    /**
     * 直接遍历数组，记录两个字符串最近出现的位置
     */

    public static int getMinDistance(String[] strs, String str1, String str2) {
        if (strs == null || strs.length == 0 || str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int last1 = -1;
        int last2 = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;//记录str1出现的位置
            }
            if (strs[i].equals(str2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;///记录str2出现的位置
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    /**
     * 进阶问题，如果发生查询的次数很多，如何将每次查询的时间复杂度变为O(1).
     *
     * 解法：通过数组生成某种记录，在查询时通过记录进行查询.
     *
     * 如果数组长度为N,那么生成记录的时间复杂度为O(N`2),记录的空间复杂度为O(N`2).
     *
     * 可以使用 HashMap<String,HashMap<String,Integer>> 来构建记录.
     *
     * 外面的map的key代表数组的某个字符串，里面的map代表的是其他字符串到当前字符串的最小距离.
     */


}
