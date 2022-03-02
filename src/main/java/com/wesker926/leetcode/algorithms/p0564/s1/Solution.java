package com.wesker926.leetcode.algorithms.p0564.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/3/2
 * @description 模拟
 */
public class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n), prefix = Long.parseLong(n.substring(0, (len + 1) / 2)), ans = -1;

        List<Long> candidates = new LinkedList<>();
        candidates.add((long) (Math.pow(10, len) + 1));
        candidates.add((long) (Math.pow(10, len - 1) - 1));
        for (long i = prefix - 1; i <= prefix + 1; i++) {
            candidates.add(Long.parseLong(i + new StringBuilder().append(i).reverse().substring(len & 1)));
        }

        for (long candidate : candidates) {
            long a = Math.abs(candidate - num), b = Math.abs(ans - num);
            if (candidate != num && (ans == -1 || a < b || (a == b && candidate < ans))) {
                ans = candidate;
            }
        }
        return Long.toString(ans);
    }
}
