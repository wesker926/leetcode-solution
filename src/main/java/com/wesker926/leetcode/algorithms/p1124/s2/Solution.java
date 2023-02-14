package com.wesker926.leetcode.algorithms.p1124.s2;

/**
 * @author wesker.gh
 * @date 2023/2/14
 * @description 哈希表
 * 同样是寻找 pre[i] - pre[j] > 0，i > j。
 * 对于前缀和pre[i]：
 * 如果pre[i]大于0，则本身就是长度为i的满足序列；
 * 如果pre[i]不大于0，且存在比它小的前缀和，则必然存在pre[i]-1的前缀和（因为前缀和是从0开始，连续变化的，参考凹曲线）。
 * 因此寻找pre[j]可以转化为哈希查找。
 */
public class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length, max = 0, pre = 0;
        int[] hash = new int[10000];
        for (int i = 1; i <= n; i++) {
            pre += hours[i - 1] > 8 ? 1 : -1;
            if (pre > 0) {
                max = Math.max(max, i);
            } else if (hash[pre + 9999] != 0) {
                max = Math.max(max, i - hash[pre + 9999]);
            }
            if (pre < 0 && hash[pre + 10000] == 0) {
                hash[pre + 10000] = i;
            }
        }
        return max;
    }
}
