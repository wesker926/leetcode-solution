package com.wesker926.leetcode.algorithms.p1247.s1;

/**
 * @author wesker.gh
 * @date 2023/2/25
 * @description 贪心
 * xy自己交换只需要一次，yx自己交换只需要一次，xy和yx交换需要两次
 * 如果diff的位置有奇数个，说明x和y的数量都是奇数个，是不能配平的
 */
public class Solution {
    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 < c2) {
                xy++;
            } else if (c1 > c2) {
                yx++;
            }
        }
        return (xy & 1) == (yx & 1) ? (xy + 1) / 2 + (yx + 1) / 2 : -1;
    }
}
