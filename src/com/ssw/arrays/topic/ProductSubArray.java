package com.ssw.arrays.topic;

/**
 * 数组中子数组的累乘积问题
 */
public class ProductSubArray {


    /**
     * 数组中子数组的最大累乘积
     * <p>
     * 给定一个double类型的数组arr，其中的元素可正、可负、可0，返回子数组累乘积的最大值
     * <p>
     * 例如：arr=[-2.5,4,0,3,0.5,8,-1]，子数组[3 ,0.5 ,8]累乘可以获得最大的乘积为12，所以返回12.
     * <p>
     * 时间复杂度O(N),额外空间复杂度O(1).
     * <p>
     * 求出以每一个位置结尾的子数组最大的累乘积，返回最大值。
     */
    public static double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res = Math.max(max, res);
        }
        return res;
    }


    /**
     * 不包含本位置的累乘数组
     * <p>
     * 题目：给定一个整型数组arr，返回不包含本位置的累乘数组
     * <p>
     * 例如：arr=[2,3,1,4],返回[12,8,24,16]
     * <p>
     * 要求时间复杂度O(N),额外空间复杂度O(1).
     * <p>
     * 方法1 使用除法
     */
    public static int[] product2(int arr[]) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i];
        }
        int tmp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * tmp;
            tmp *= arr[i];
        }
        res[0] = tmp;
        return res;
    }

    //i位置除去自己值的累乘 ，就是自己左面的累乘*右面的累乘 res[i] = l[i-1] * r[i+1]
    public static int[] product3(int arr[]) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] l = new int[arr.length];
        int[] r = new int[arr.length];

        l[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            l[i] = l[i - 1] * arr[i];
        }

        r[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i > 0; i--) {
            r[i] = r[i + 1] * arr[i];
        }

        int[] res = new int[arr.length];
        res[0] = r[1];
        res[arr.length - 1] = l[arr.length - 2];
        for (int i = 1; i < arr.length - 1; i++) {
            res[i] = l[i - 1] * r[i + 1];
        }
        return res;
    }


    public static void main(String[] args) {
//        double[] arr = {-2.5, 4, 0, 3, 0.5, 8, -1};
//        System.out.println(maxProduct(arr));

        int[] arr = {2, 3, 1, 4};
        int[] res1 = product2(arr);
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + " ");
        }
        System.out.println("");
        System.out.println("---------------------------");
        int[] res2 = product3(arr);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
    }
}
