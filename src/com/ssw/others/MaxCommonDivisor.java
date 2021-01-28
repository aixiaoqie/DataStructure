package com.ssw.others;

/**
 * 一行代码求两个数的最大公约数
 */
public class MaxCommonDivisor {

    /**
     * 欧几里得 辗转相除法求最大公约数
     * <p>
     * 如果q r分别是m除以n的商和余数 即 m=qn+r ,那么m 和n的最大公约数等于n和r的最大公约数
     */


    public static int getMaxDivisor(int m, int n) {
        return n == 0 ? m : getMaxDivisor(n, m % n); //除数 和余数的最大公约数
    }
}
