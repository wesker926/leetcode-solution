package com.wesker926.leetcode.algorithms.p0165.s1;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 四指针
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length(), l1 = 0, r1 = 0, l2 = 0, r2 = 0;
        for (; r1 < m || r2 < n; l1 = r1 + 1, l2 = r2 + 1, r1++, r2++) {
            for (; r1 < m && version1.charAt(r1) != '.'; r1++) {
            }
            for (; r2 < n && version2.charAt(r2) != '.'; r2++) {
            }
            int i1 = l1 < r1 ? Integer.parseInt(version1, l1, r1, 10) : 0;
            int i2 = l2 < r2 ? Integer.parseInt(version2, l2, r2, 10) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
}
