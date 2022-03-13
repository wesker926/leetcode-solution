package com.wesker926.leetcode.algorithms.p0393.s1;

/**
 * @author wesker.gh
 * @date 2022/3/13
 * @description 二进制运算
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0, j, k; i < n; ) {
            if ((data[i] & 128) == 0) {
                i++;
                continue;
            }
            for (j = 64, k = 1; j > 0 && (data[i] & j) != 0; j >>= 1, k++) {
            }
            if (k < 2 || k > 4 || i + k > n) {
                return false;
            }
            for (j = i + 1; j < i + k; j++) {
                if ((data[j] & 128) == 0 || (data[j] & 64) != 0) {
                    return false;
                }
            }
            i = j;
        }
        return true;
    }
}
