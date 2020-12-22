package src.com.ssw.arrays.topic;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据不同条件 获取最大子数组长度
 */
public class MaxSubArray {


    /**
     * 无序正数数组，求累加值为k的最长子数组
     * 不考虑类型越界问题
     * 时间复杂度O(N),额外空间复杂度O(1)
     */
    public int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }

        int left = 0, right = 0, len = 0;
        int sum = arr[0];
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1); //更新最大子数组长度
                sum -= arr[left++];// 正数数组arr[left,right] 的和与 给定k值相等，说明arr[left,right+1]的值一定大于k，此时需要移动left，找到下一个与sum与k相等的区域
            } else if (sum < k) { //sum 小于k，说明正数数组arr[left,right]的right需要移动
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {  //sum > K ,说明正数数组arr[left,right]的区域和已经大于定值k,从left开始往右所有子数组都大于k，需要移动left，考察left+1开始的子数组
                sum -= arr[left++];
            }
        }
        return len;
    }


    /**
     * 无序数组，求累加值为k的最大子数组长度
     * 时间复杂的O(N),额外空间复杂度O(N)
     * <p>
     * sum(i) 为数组arr[0,i]的累加值，sum(j)为数组arr[0,j]的累计值   ( 0<=j<=i<arr.length )
     * 如果 sum(i) -sum(j) = k;说明 arr[j+1,i]的sum值为k
     * <p>
     * <p>
     * 补充问题1： 无序数组arr,其中有正数、负数、0，求其中正数与负数个数相同的最大子数组长度
     * 解法：将其中正数变为1，负数变为-1，0不变，求此时这个数组累加值为0的最大子数组长度
     * <p>
     * <p>
     * 补充问题2： 无序数组arr,其中有只有0，1，求其中0的个数与1的个数相同的最大子数组长度
     * 解法：将其中0变为-1，求此时这个数组累加值为0的最大子数组长度
     */
    public int getMaxSubArrLength(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();//负责存储数组循环sum值第一次出现的位置(sum,i)
        map.put(-1, 0);//arr[j+1,i]的累加值为k，如果从0位置开始累加会导致从0位置的数组被排除，需要从-1位置开始累加
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {//获取s(j)出现的位置
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i); //记录sum值第一次出现时的数组位置，获得最长子数组
            }
        }
        return len;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4};
//        MaxSubArray maxSubArray = new MaxSubArray();
//        int length = maxSubArray.getMaxLength(arr, 4);
//        System.out.println("正数数组总和为4的最大子数组长度为：" + length);

        int[] arr = {-1, -2, -1, -1, 2, 2, 3, 3, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
        int length = maxSubArray.getMaxSubArrLength(arr, 2);
        System.out.println("数组总和为4的最大子数组长度为：" + length);

    }

}
