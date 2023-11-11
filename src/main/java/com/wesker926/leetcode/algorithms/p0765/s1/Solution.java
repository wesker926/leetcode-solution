package com.wesker926.leetcode.algorithms.p0765.s1;

/**
 * @author wesker.gh
 * @date 2023/11/11
 * @description 贪心
 * 最小交换次数 = N - 图中已有的连通分量
 * 可证明每次交换不会增加超过一个连通分量，且每次增加一个连通分量的操作必然存在（凑一对即可），因此每次增加一个连通分量的操作一定是最优解
 * https://leetcode.cn/problems/couples-holding-hands/solutions/40592/qing-lu-qian-shou-by-leetcode/?envType=daily-question&envId=2023-11-11
 */
public class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length, ans = n >> 1;
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) idx[row[i]] = i;
        for (int i = 0; i < n; i += 2) {
            if (row[i] < 0) continue;
            for (int j = i, k; row[j] >= 0; j = k) {
                k = idx[row[j ^ 1] ^ 1];
                row[j] = row[j ^ 1] = -1;
            }
            ans--;
        }
        return ans;
    }
}
