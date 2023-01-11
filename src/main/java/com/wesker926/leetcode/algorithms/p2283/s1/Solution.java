package com.wesker926.leetcode.algorithms.p2283.s1;

/**
 * @author wesker.gh
 * @date 2023/1/11
 * @description 哈希表
 */
public class Solution {
    public boolean digitCount(String num) {
        int[] bucket = new int[10];
        for (int i = 0; i < num.length(); i++) {
            int k = num.charAt(i) - '0';
            bucket[i] += k;
            bucket[k]--;
        }
        for (int i : bucket) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
