package com.wesker926.leetcode.algorithms.p2679.s1;

/**
 * @author wesker.gh
 * @date 2023/7/4
 * @description 排序
 * 可以用计数排序
 */
public class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums[0].length, ans = 0;
        int[] table = new int[1001], max = new int[n];
        for (int[] col : nums) {
            for (int num : col) table[num]++;
            for (int i = 0, idx = 0; idx < n; idx++, table[i]--) {
                for (; table[i] == 0; i++) ;
                max[idx] = Math.max(max[idx], i);
            }
        }
        for (int num : max) ans += num;
        return ans;
    }
}
