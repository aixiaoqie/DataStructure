package com.ssw.string.topic;


/**
 * 给定一个字符串str，如果str符合日常书写的整数形式，并且属于32位整数的范围，返回str代表的整数值，否则返回0。
 */
public class ConvertString2Integer {

    /**
     * 先判断字符串是否符合日常书写形式
     */
    public boolean isValid(char[] arr) {
        if (arr[0] == '-' && (arr[0] > '9' || arr[0] < '0')) {
            return false;
        }
        if (arr[0] == '-' && (arr.length == 1 || arr[1] == '0')) {
            return false;
        }
        if (arr[0] == '0' && arr.length > 1) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < '0' || arr[0] > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * 然后将符合条件的字符串转成整数
     */
    public int convert(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        if (!isValid(arr)) {
            return 0;
        }
        boolean positive = arr[0] == '-' ? false : true;
        int minQuotient = Integer.MIN_VALUE / 10; //最小商 当res小于此值时，后面如果还有字符，res*10 + cur 一定越界
        int minResidue = Integer.MIN_VALUE % 10; //余数 当res = minQuotient 且 cur < minResidue,res*10 + cur 一定越界
        int res = 0;
        int cur = 0;
        for (int i = positive ? 0 : 1; i < arr.length; i++) {
            cur = '0' - arr[i]; //所有值都用负数进行计算，到最后返回时判断正负
            if ((res < minQuotient) || (res == minQuotient && cur < minResidue)) {
                return 0; //数字超过int最大范围直接返回0
            }
            res = res * 10 + cur;
        }
        if (positive && res == Integer.MIN_VALUE) {
            return 0; //如果数字为 2147483648，使用负数进行计算，-2147483648不越界，当转成正数时越界，所以直接返回0
        }
        return positive ? -res : res;
    }

}
