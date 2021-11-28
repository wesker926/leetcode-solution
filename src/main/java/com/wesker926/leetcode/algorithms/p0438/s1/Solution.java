package com.wesker926.leetcode.algorithms.p0438.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/11/28
 * @description 滑动窗口 + 判断优化
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        char[] cs = s.toCharArray(), cp = p.toCharArray();
        int[] map = new int[26];
        for (char c : cp) {
            map[c - 'a']++;
        }

        int count = cp.length, right = 0, temp;
        for (int l = 0, r = 0; r < cs.length; r++) {
            temp = cs[r] - 'a';
            if (map[temp] > 0) {
                right++;
            }
            map[temp]--;

            if (right == count) {
                result.add(l);
            }

            if (r - l + 1 >= count) {
                temp = cs[l] - 'a';
                if (map[temp] >= 0) {
                    right--;
                }
                map[temp]++;
                l++;
            }
        }
        return result;
    }
}
