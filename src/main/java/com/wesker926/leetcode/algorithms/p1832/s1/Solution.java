package com.wesker926.leetcode.algorithms.p1832.s1;

/**
 * @author wesker.gh
 * @date 2022/12/13
 * @description 二进制
 * 26个字母可用int代替数组
 */
public class Solution {
    public boolean checkIfPangram(String sentence) {
        int bit = 0, target = (1 << 26) - 1;
        for (char c : sentence.toCharArray()) {
            bit |= 1 << (c - 'a');
            if (bit == target) {
                return true;
            }
        }
        return false;
    }
}
