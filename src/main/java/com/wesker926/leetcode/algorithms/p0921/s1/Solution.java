package com.wesker926.leetcode.algorithms.p0921.s1;

/**
 * @author wesker.gh
 * @date 2022/10/4
 * @description 贪心
 * 无需栈（使用cnt替代）
 */
public class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (cnt > 0) {
                cnt--;
            } else {
                ans++;
            }
        }
        return cnt + ans;
    }
}
