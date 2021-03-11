package com.ssw.recursive;

/**
 * 求n的阶乘
 * Factorial [fækˈtɔːriəl]  美 [fækˈtɔːriəl]
 * adj. 因子的，阶乘的
 * n. [数] 阶乘
 */
public class Factorial {


    /**
     * 递归
     */
    public long getFactorial(int n) {
        if (n == 1) {
            return 1l;
        }
        return n * getFactorial(n - 1);
    }

    //非递归
    public long getFactorialNonRecursive(int n) {
        long res = 1L;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        long factorial = new Factorial().getFactorial(4);
        System.out.println(factorial);
    }

}
