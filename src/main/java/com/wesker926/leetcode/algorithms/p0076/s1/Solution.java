package com.wesker926.leetcode.algorithms.p0076.s1;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 滑动窗口
 */
public class Solution {
    public String minWindow(String s, String t) {
        int len = -1, idx = 0;
        int m = s.length(), n = t.length(), total = n;
        int[] need = new int[128], have = new int[128];
        for (int i = 0; i < n; i++) {
            need[t.charAt(i)]++;
        }
        for (int i = 0, j = 0; j < m; j++) {
            char c1 = s.charAt(j), c2;
            if (need[c1] == 0) {
                continue;
            }
            if (have[c1] < need[c1]) {
                total--;
            }
            have[c1]++;
            for (c2 = s.charAt(i); have[c2] > need[c2] || need[c2] == 0; i++, c2 = s.charAt(i)) {
                if (need[c2] == 0) {
                    continue;
                }
                have[c2]--;
            }
            if (total == 0 && (len < 0 || j - i + 1 < len)) {
                len = j - i + 1;
                idx = i;
            }
        }
        return len < 0 ? "" : s.substring(idx, idx + len);
    }
}
