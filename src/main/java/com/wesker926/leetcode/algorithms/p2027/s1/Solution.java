package com.wesker926.leetcode.algorithms.p2027.s1;

/**
 * @author wesker.gh
 * @date 2022/12/27
 * @description 贪心遍历
 */
public class Solution {
    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 2;
            }
        }
        return ans;
    }
}
