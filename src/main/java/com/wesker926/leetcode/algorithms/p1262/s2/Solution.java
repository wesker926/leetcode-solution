package com.wesker926.leetcode.algorithms.p1262.s2;

/**
 * @author wesker.gh
 * @date 2023/6/19
 * @description 贪心
 * 逆向贪心 - 根据sum的模减去使其可被整除的最小值
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int[][] min = new int[][]{{10001, 10001}, {10001, 10001}};
        for (int num : nums) {
            sum += num;
            int mod = (num % 3) - 1;
            if (mod < 0) continue;
            if (num <= min[mod][0]) {
                min[mod][1] = min[mod][0];
                min[mod][0] = num;
            } else if (num <= min[mod][1]) {
                min[mod][1] = num;
            }
        }
        int mod = (sum % 3) - 1;
        return mod < 0 ? sum : sum - Math.min(min[mod][0], min[1 - mod][0] + min[1 - mod][1]);
    }
}
