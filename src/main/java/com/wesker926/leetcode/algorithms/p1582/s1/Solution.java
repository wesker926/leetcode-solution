package com.wesker926.leetcode.algorithms.p1582.s1;

/**
 * @author wesker.gh
 * @date 2022/9/4
 * @description 列的标记值
 * 模拟法需要O(m + n)的空间，列标记可以原地
 * 列标记为1是该列有特殊位置的充要条件
 */
public class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    sum++;
                }
            }
            if (i == 0) {
                sum--;
            }
            if (sum > 0) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        mat[0][j] += sum;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (mat[0][j] == 1) {
                ans++;
            }
        }
        return ans;
    }
}
