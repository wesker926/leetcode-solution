package com.wesker926.leetcode.algorithms.p1326.s1;

/**
 * @author wesker.gh
 * @date 2023/2/21
 * @description 贪心
 * 这题思路跟主站-p0045（跳跃游戏II）一样
 * 注意arr[0]是被截断的，因此要用max处理
 */
public class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int idx = Math.max(i - ranges[i], 0);
            arr[idx] = Math.max(arr[idx], Math.min(i + ranges[i], n));
        }
        int ans = 0;
        for (int i = 0, cur = 0, nxt; cur < n; ans++, cur = nxt) {
            for (nxt = cur; i <= cur; i++) {
                nxt = Math.max(nxt, arr[i]);
            }
            if (nxt == cur) {
                return -1;
            }
        }
        return ans;
    }
}
