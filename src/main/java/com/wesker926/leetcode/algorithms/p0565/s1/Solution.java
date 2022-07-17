package com.wesker926.leetcode.algorithms.p0565.s1;

/**
 * @author wesker.gh
 * @date 2022/7/17
 * @description 原地标记
 * 该图必然由若干个环组成，只需要找到最大的环即可
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for (int i = 0, j, cur; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            }
            for (j = i, cur = 0; nums[j] >= 0; cur++) {
                int t = nums[j];
                nums[j] = -nums[j] - 1;
                j = t;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
