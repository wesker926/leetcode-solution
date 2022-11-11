package com.wesker926.leetcode.algorithms.p1704.s1;

/**
 * @author wesker.gh
 * @date 2022/11/11
 * @description 遍历计数
 * 元音判断的方式有多种选择
 */
public class Solution {

    private static final int vowelMask = 0b00000100000100000100010001;

    public boolean halvesAreAlike(String s) {
        int n = s.length(), count = 0;
        for (int i = 0; i < n / 2; i++) {
            count += ((vowelMask >> (Character.toLowerCase(s.charAt(i)) - 'a')) & 1) -
                    ((vowelMask >> (Character.toLowerCase(s.charAt(n - 1 - i)) - 'a')) & 1);
        }
        return count == 0;
    }
}
