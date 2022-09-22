package com.wesker926.leetcode.algorithms.p1640.s1;

/**
 * @author wesker.gh
 * @date 2022/9/22
 * @description 哈希表
 */
public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] hash = new int[101];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = i + 1;
        }
        for (int[] piece : pieces) {
            if (hash[piece[0]] == 0) {
                return false;
            }
            if (piece.length == 1) {
                continue;
            }
            for (int i = 1; i < piece.length; i++) {
                if (hash[piece[i]] == 0 || hash[piece[i]] != hash[piece[i - 1]] + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
