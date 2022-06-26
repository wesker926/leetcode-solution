package com.wesker926.leetcode.algorithms.p0710.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/26
 * @description 二分映射
 */
public class Solution {

    private final int n;

    private final int[] blackList;

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(n, blacklist);
     * int param_1 = obj.pick();
     */
    public Solution(int n, int[] blacklist) {
        this.n = n;
        this.blackList = blacklist;
        Arrays.sort(this.blackList);
    }

    public int pick() {
        return binary((int) (Math.random() * (n - blackList.length)));
    }

    private int binary(int t) {
        int l = 0, r = blackList.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (blackList[m] < t + m + 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return t + r + 1;
    }
}
