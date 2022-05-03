package com.wesker926.leetcode.algorithms.p0067.s1;

/**
 * @author wesker.gh
 * @date 2022/5/3
 * @description 模拟
 */
public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length(), idx = Math.max(m, n);
        char[] cs1 = a.toCharArray();
        char[] cs2 = b.toCharArray();
        char[] ans = new char[idx + 1];
        for (int i = m - 1, j = n - 1, carry = 0; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            carry += (i >= 0 ? cs1[i] - '0' : 0) + (j >= 0 ? cs2[j] - '0' : 0);
            ans[idx--] = (char) ((carry & 1) + '0');
            carry >>= 1;
        }
        return new String(ans, idx + 1, ans.length - idx - 1);
    }
}
