package com.ssw.recursive;

/**
 * 汉诺塔问题
 */
public class Hanoi {

    public static void hanoi(int n, String from, String to, String help) {
        if (n == 1) { //base case 基本情况
            System.out.println("move " + 1 + " from " + from + " to " + to);
        } else {
            hanoi(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            hanoi(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        hanoi(3, "left", "right", "mid");
    }
}
