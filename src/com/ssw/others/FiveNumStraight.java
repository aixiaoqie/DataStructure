package com.ssw.others;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class FiveNumStraight {


    public boolean isStraight(int[] nums) {

        Arrays.sort(nums);

        int zeroNum = 0;
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }

                if (nums[i] + 1 != nums[i + 1]) {
                    diff += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return zeroNum >= diff;
    }
}
