package com.wesker926.leetcode.algorithms.p0869.s2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wesker.gh
 * @date 2021/10/28
 * @description sort and compare
 */
public class Solution {

    private final Set<String> set;

    {
        set = new HashSet<>();
        for (int i = 1; i <= 1000000000; i <<= 1) {
            set.add(numToStr(i));
        }
    }

    public boolean reorderedPowerOf2(int n) {
        return set.contains(numToStr(n));
    }

    private String numToStr(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
