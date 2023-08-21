package com.wesker926.leetcode.algorithms.p2337.s1;

/**
 * @author wesker.gh
 * @date 2023/8/21
 * @description 双指针
 * 官解解释的不错
 * https://leetcode.cn/problems/move-pieces-to-obtain-a-string/solutions/1855012/yi-dong-pian-duan-de-dao-zi-fu-chuan-by-0j7py/
 */
public class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length(), cnt = 0;
        for (int i = 0; i < n; i++) if (target.charAt(i) == '_') cnt++;
        for (int i = 0, j = 0, sc = 0, tc = 0; i < n || j < n; i++, j++) {
            for (; i < n && start.charAt(i) == '_'; i++) sc++;
            for (; j < n && target.charAt(j) == '_'; j++) tc++;
            if (i >= n && j >= n) break;
            if (i >= n || j >= n || start.charAt(i) != target.charAt(j)) return false;
            if (start.charAt(i) == 'L' && (cnt - sc) > (cnt - tc)) return false;
            if (start.charAt(i) == 'R' && sc > tc) return false;
        }
        return true;
    }
}
