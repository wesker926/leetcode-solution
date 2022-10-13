package com.wesker926.leetcode.algorithms.p0769.s1;

/**
 * @author wesker.gh
 * @date 2022/10/13
 * @description 贪心
 * curNeed相当于人工维护了解法2的idx
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, curNeed = 0, lastMax = -1;
        for (int num : arr) {
            if (num > lastMax) {
                curNeed += num - lastMax;
                lastMax = num;
            }
            if (--curNeed == 0) {
                ans++;
            }
        }
        return ans;
    }
}
