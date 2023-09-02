package com.wesker926.leetcode.algorithms.p2511.s1;

/**
 * @author wesker.gh
 * @date 2023/9/2
 * @description 模拟
 * 找相邻的距离最远的1和-1
 */
public class Solution {
    public int captureForts(int[] forts) {
        int ans = 0, pre = -1, n = forts.length;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 0) continue;
            if (pre >= 0 && forts[i] != forts[pre]) ans = Math.max(ans, i - pre - 1);
            pre = i;
        }
        return ans;
    }
}
