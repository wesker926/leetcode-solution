package com.wesker926.leetcode.algorithms.p1330.s1;

/**
 * @author wesker.gh
 * @date 2023/5/12
 * @description 分类讨论
 * 很复杂，参考下面题解的分类讨论
 * https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/solutions/2265390/fan-zhuan-zi-shu-zu-de-dao-zui-da-de-shu-t9jv/
 * https://leetcode.cn/problems/reverse-subarray-to-maximize-array-value/solutions/2266500/bu-hui-hua-jian-qing-kan-zhe-pythonjavac-c2s6/
 */
public class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length, val = 0, delta = 0;
        for (int i = 0; i < n - 1; i++) {
            val += Math.abs(nums[i] - nums[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            delta = Math.max(delta, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            delta = Math.max(delta, Math.abs(nums[i - 1] - nums[n - 1]) - Math.abs(nums[i - 1] - nums[i]));
        }
        int maxMin = Integer.MIN_VALUE, minMax = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxMin = Math.max(maxMin, Math.min(nums[i], nums[i + 1]));
            minMax = Math.min(minMax, Math.max(nums[i], nums[i + 1]));
        }
        return val + Math.max(delta, 2 * (maxMin - minMax));
    }
}
