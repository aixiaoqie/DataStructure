package src.com.ssw.arrays.topic;

/**
 * 根据不同条件 获取最大子数组长度
 */
public class MaxSubArray {


    /**
     * 无序正数数组，求累加值为k的最长子数组
     * 不考虑数组越界问题
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

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
        int length = maxSubArray.getMaxLength(arr, 4);
        System.out.println("正数数组总和为4的最大子数组长度为：" + length);
    }

}
