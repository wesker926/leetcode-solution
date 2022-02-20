package com.wesker926.leetcode.algorithms.p0717.s1;

/**
 * @author wesker.gh
 * @date 2022/2/20
 * @description 遍历（此编码为异前缀编码，无歧义）
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        while (idx < bits.length - 1) {
            idx += bits[idx] == 1 ? 2 : 1;
        }
        return idx != bits.length;
    }
}
