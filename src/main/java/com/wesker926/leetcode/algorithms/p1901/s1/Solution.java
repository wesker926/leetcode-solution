package com.wesker926.leetcode.algorithms.p1901.s1;

/**
 * @author wesker.gh
 * @date 2023/12/19
 * @description 二分
 * 思路不是很好想，参考题解
 * https://leetcode.cn/problems/find-a-peak-element-ii/solutions/2571587/tu-jie-li-yong-xing-zui-da-zhi-pan-duan-r4e0n/?envType=daily-question&envId=2023-12-19
 */
public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l = 0, r = mat.length - 1;
        while (l < r) {
            int i = l + (r - l) / 2;
            int j = idxOfMax(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                r = i;
            } else {
                l = i + 1;
            }
        }
        return new int[]{l, idxOfMax(mat[l])};
    }

    private int idxOfMax(int[] a) {
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[idx]) idx = i;
        }
        return idx;
    }
}
