package com.wesker926.leetcode.algorithms.p0825.s1;

/**
 * @author wesker.gh
 * @date 2021/12/27
 * @description 前缀和
 * 注意：条件3蕴含在条件2里
 */
public class Solution {
    public int numFriendRequests(int[] ages) {
        int[] pre = new int[121];
        for (int age : ages) {
            pre[age]++;
        }
        for (int i = 0, sum = 0; i < pre.length; i++) {
            sum += pre[i];
            pre[i] = sum;
        }

        int ans = 0;
        for (int i = 15, j; i < pre.length; i++) {
            j = pre[i] - pre[i - 1];
            if (j > 0) {
                ans += j * (pre[i] - pre[(i >>> 1) + 7] - 1);
            }
        }
        return ans;
    }
}
