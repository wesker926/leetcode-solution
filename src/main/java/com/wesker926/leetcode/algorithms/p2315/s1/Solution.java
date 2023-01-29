package com.wesker926.leetcode.algorithms.p2315.s1;

/**
 * @author wesker.gh
 * @date 2023/1/29
 * @description 遍历
 */
public class Solution {
    public int countAsterisks(String s) {
        int ans = 0, mark = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                mark ^= 1;
            } else if (ch == '*' && mark == 0) {
                ans++;
            }
        }
        return ans;
    }
}
