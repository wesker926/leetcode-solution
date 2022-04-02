package com.wesker926.leetcode.algorithms.p0420.s2;

/**
 * @author wesker.gh
 * @date 2022/4/2
 * @description 分类讨论
 */
public class Solution {
    public int strongPasswordChecker(String password) {
        char[] ps = password.toCharArray();
        int n = ps.length, lack = 0, add = 0, replace = 0, sub = 0;
        int[] modCount = new int[3];
        for (int i = 0, j; i < n; i = j) {
            char ch = ps[i];
            if (Character.isUpperCase(ch)) {
                lack |= 1;
            } else if (Character.isLowerCase(ch)) {
                lack |= 2;
            } else if (Character.isDigit(ch)) {
                lack |= 4;
            }
            for (j = i + 1; j < n && ps[i] == ps[j]; j++) {
            }
            if (j - i > 2) {
                replace += (j - i) / 3;
                modCount[(j - i) % 3]++;
            }
        }
        lack = 3 - Integer.bitCount(lack);

        if (n < 6) {
            add = 6 - n;
            replace = Math.max(0, lack - add);
        } else if (n <= 20) {
            replace = Math.max(replace, lack);
        } else {
            for (int i = 0, step, count; i < modCount.length && n > 20; i++, n -= step, replace -= count, sub += step) {
                if (i == 2) {
                    modCount[i] = replace;
                }
                count = Math.min(modCount[i], (n - 20) / (i + 1));
                step = count * (i + 1);
            }
            sub += n - 20;
            replace = Math.max(replace, lack);
        }

        return add + replace + sub;
    }
}
