package com.wesker926.leetcode.algorithms.p2465.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/6/4
 * @description 排序 + 哈希表
 */
public class Solution {
    public int distinctAverages(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        boolean[] table = new boolean[201];
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (!table[nums[i] + nums[j]]) ans++;
            table[nums[i] + nums[j]] = true;
        }
        return ans;
    }
}
