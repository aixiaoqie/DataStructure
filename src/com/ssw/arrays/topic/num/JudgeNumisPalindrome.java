package com.ssw.arrays.topic.num;

/**
 * 判断一个数是否是回文数
 */
public class JudgeNumisPalindrome {

    public static boolean isPalindrome(int num) {
        if (num == Integer.MIN_VALUE) {
            return false;
        }
        num = Math.abs(num);
        int help = 1;
        while (num / help >= 10) {
            help *= 10;
        }
        while (num != 0) {
            if (num / help != num % 10) {
                return false;
            }
            num = (num % help) / 10;  //将num的最高位和最低位雀鲷变为新的数
            help /= 100; //将help的位数与num的位数保持一致。
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 122332211;
        System.out.println(isPalindrome(num));
    }
}
