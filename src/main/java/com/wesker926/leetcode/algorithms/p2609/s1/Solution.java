package com.wesker926.leetcode.algorithms.p2609.s1;

/**
 * @author wesker.gh
 * @date 2023/11/8
 * @description 计数
 */
public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        for (int i = 0, j = 0, z = 0, n = s.length(); j < n; j++) {
            if (s.charAt(j) == '0') z++;
            else if (j + 1 == n || s.charAt(j + 1) == '0') {
                ans = Math.max(ans, Math.min(z, j - i + 1 - z) << 1);
                i = j + 1;
                z = 0;
            }
        }
        return ans;
    }
}
