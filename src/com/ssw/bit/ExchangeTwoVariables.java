package com.ssw.bit;

/**
 * 不用额外变量交换两个整数的值
 */
public class ExchangeTwoVariables {
    /**
     * 给定整数a,b 不用其他变量交换两个整数的值
     */
    public void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
