package com.wesker926.leetcode.algorithms.p0915.s2;

/**
 * @author wesker.gh
 * @date 2022/10/24
 * @description 无需辅助数组
 * 记录当前max，并记录当前能够找到的left的max和pos
 * 如果nums[i]小于leftMax，说明left需要更新（以包含i）
 * 使leftMax=curMax，leftPos=i
 * 这样就能保证left区间数始终不大于right区间数
 */
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftPos = 0, leftMax = nums[0], curMax = leftMax;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }
}
