package com.wesker926.leetcode.algorithms.p1124.s2;

/**
 * @author wesker.gh
 * @date 2023/2/14
 * @description 哈希表
 * 对于前缀和pre[i]：
 * 如果pre[i]大于0，则本身就是长度为i的满足序列；
 * 如果pre[i]不大于0，且存在比它小的前缀和，则必然存在pre[i]-1的前缀和（因为前缀和是连续变化的）
 */
public class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length, max = 0;
        int[] pre = new int[n + 1], hash = new int[10000];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (pre[i] < 0 && hash[pre[i] + 10000] == 0) {
                hash[pre[i] + 10000] = i;
            }
            if (pre[i] > 0) {
                max = Math.max(max, i);
            } else if (hash[pre[i] + 9999] != 0) {
                max = Math.max(max, i - hash[pre[i] + 9999]);
            }
        }
        return max;
    }
}
