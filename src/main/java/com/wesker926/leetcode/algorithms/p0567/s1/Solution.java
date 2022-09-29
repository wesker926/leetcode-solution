package com.wesker926.leetcode.algorithms.p0567.s1;

/**
 * @author wesker.gh
 * @date 2022/9/29
 * @description 双指针滑动窗口 + 哈希表
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] target = new int[26], bucket = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }
        for (int i = 0, j = 0, c = 0; j < n; j++) {
            int cur = s2.charAt(j) - 'a';
            if (target[cur] == 0) {
                bucket = new int[26];
                c = 0;
                i = j + 1;
                continue;
            }
            if (bucket[cur] >= target[cur]) {
                for (; s2.charAt(i) != s2.charAt(j); i++, c--) {
                    bucket[s2.charAt(i) - 'a']--;
                }
                i++;
                continue;
            }
            bucket[cur]++;
            if (++c == m) {
                return true;
            }
        }
        return false;
    }
}
