package com.wesker926.leetcode.algorithms.p0904.s1;

/**
 * @author wesker.gh
 * @date 2022/10/17
 * @description 滑动窗口
 * 求只包含两种元素的最长连续子数组的长度
 */
public class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0, i = 0, j = 0;
        for (int f = -1, s = -1, type = 0; j < fruits.length; j++) {
            if (fruits[j] == f || fruits[j] == s) {
                continue;
            }
            if (type == 2) {
                ans = Math.max(ans, j - i);
                for (i = j; fruits[i - 1] == fruits[j - 1]; i--) {
                }
                if (f == fruits[j - 1]) {
                    s = fruits[j];
                } else {
                    f = fruits[j];
                }
                continue;
            }

            type++;
            if (f == -1) {
                f = fruits[j];
            } else {
                s = fruits[j];
            }
        }
        return Math.max(ans, j - i);
    }
}
