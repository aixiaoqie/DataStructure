package com.ssw.string.topic;

/**
 * 括号有效性问题
 */
public class BracketsValid {
    /**
     * 1. 给定一个字符串，判断是不是整体有效的括号
     * <p>
     * 解：遍历每个字符，若出现其他字符返回false；
     * 记录每个左括号与右括号的个数，若右括号比左括号多，返回false
     * 遍历完成后检查左右括号数量是否相等。
     */
    public static boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        char[] array = str.toCharArray();
        int lNum = 0;
        int rNum = 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != '(' && array[i] != ')') {
                return false;
            }
            if (array[i] == '(') {
                num++;
            }
            if (array[i] == ')' && --num < 0) {
                return false;
            }
        }
        return num == 0;
    }

    /**
     * 补充问题：给定一个括号字符串，返回最长有效字长度。
     */
    // TODO: 2021/1/8 动态规划 
    // TODO: 2021/2/5  动态规划 
}
