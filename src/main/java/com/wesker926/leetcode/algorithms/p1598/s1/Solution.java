package com.wesker926.leetcode.algorithms.p1598.s1;

/**
 * @author wesker.gh
 * @date 2022/9/9
 * @description 遍历模拟
 */
public class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                ans = Math.max(0, ans - 1);
            } else if (!"./".equals(log)) {
                ans++;
            }
        }
        return ans;
    }
}
