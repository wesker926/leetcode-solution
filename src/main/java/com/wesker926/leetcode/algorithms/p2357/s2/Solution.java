package com.wesker926.leetcode.algorithms.p2357.s2;

/**
 * @author wesker.gh
 * @date 2023/2/24
 * @description 统计不同元素的个数
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        boolean[] exist = new boolean[101];
        exist[0] = true;
        for (int num : nums) {
            if (!exist[num]) {
                cnt++;
                exist[num] = true;
            }
        }
        return cnt;
    }
}
