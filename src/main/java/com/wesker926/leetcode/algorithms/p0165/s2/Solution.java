package com.wesker926.leetcode.algorithms.p0165.s2;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 双指针
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        for (int i = 0, j = 0, x, y; i < m || j < n; i++, j++) {
            for (x = 0; i < m && version1.charAt(i) != '.'; i++) {
                x = x * 10 + (version1.charAt(i) - '0');
            }
            for (y = 0; j < n && version2.charAt(j) != '.'; j++) {
                y = y * 10 + (version2.charAt(j) - '0');
            }
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
