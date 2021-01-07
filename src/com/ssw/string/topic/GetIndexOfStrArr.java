package com.ssw.string.topic;

/**
 * 在有序但含有null的字符串数组中查找字符串
 * <p>
 * 给定一个字符串数组strs[],在strs有些地方为null，其字符串是按照字典顺序由小到大排序依次出现。给定一个字符串，查找其在字符串数组出现最左的位置。
 */
public class GetIndexOfStrArr {

    public int getIndex(String strs[], String str) {
        if (strs == null || str.length() == 0 || str == null) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && --mid >= left) ;//从右到左找到左侧区域不为null的位置
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    res = strs[i].equals(str) ? i : res;
                    right = mid - 1;
                }
            }
        }
        return res;
    }
}
