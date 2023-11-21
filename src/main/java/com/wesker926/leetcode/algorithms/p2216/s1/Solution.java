package com.wesker926.leetcode.algorithms.p2216.s1;

/**
 * @author wesker.gh
 * @date 2023/11/21
 * @description 贪心
 * 删除当前遍历位置的数是严格最优策略
 * https://leetcode.cn/problems/minimum-deletions-to-make-array-beautiful/solutions/2530304/mei-hua-shu-zu-de-zui-shao-shan-chu-shu-qx4af/?envType=daily-question&envId=2023-11-21
 */
public class Solution {
    public int minDeletion(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0, j; i < n; ) {
            for (j = i + 1; j < n && nums[i] == nums[j]; ans++, j++) ;
            if ((i = j + 1) == n + 1) ans++;
        }
        return ans;
    }
}
