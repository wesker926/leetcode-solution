package com.wesker926.leetcode.algorithms.p2454.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/12/12
 * @description 双单调栈
 * https://leetcode.cn/problems/next-greater-element-iv/solutions/2562064/xia-yi-ge-geng-da-yuan-su-iv-by-leetcode-hjqv/?envType=daily-question&envId=2023-12-12
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length, i1 = 0, i2 = 0;
        int[] ans = new int[n], s1 = new int[n], s2 = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0, j; i < n; i++, i1 = j + 1) {
            while (i2 > 0 && nums[s2[i2 - 1]] < nums[i]) ans[s2[--i2]] = nums[i];
            for (j = i1; j > 0 && nums[s1[j - 1]] < nums[i]; ) j--;
            for (int k = j; k < i1; k++) s2[i2++] = s1[k];
            s1[j] = i;
        }
        return ans;
    }
}
