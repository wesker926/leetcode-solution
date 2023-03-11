package com.wesker926.leetcode.igc.p17_05.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/3/11
 * @description 前缀和
 * 二元逆推性质 -> 两数之和
 */
public class Solution {
    public String[] findLongestSubarray(String[] array) {
        int diff = 100000, st = 0, ed = 0;
        int[] index = new int[200001];
        for (int i = 0; i < array.length; i++) {
            if (index[diff] == 0) {
                index[diff] = i + 1;
            }
            diff += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            if (index[diff] != 0) {
                if (ed - st < i - index[diff] + 2) {
                    ed = i + 1;
                    st = index[diff] - 1;
                }
            }
        }
        return Arrays.copyOfRange(array, st, ed);
    }
}
