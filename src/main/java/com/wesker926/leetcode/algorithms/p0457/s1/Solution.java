package com.wesker926.leetcode.algorithms.p0457.s1;

/**
 * @author wesker.gh
 * @date 2022/6/30
 * @description 原地标记
 * 也可以用快慢指针做
 */
public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length, offset = 1001;
        for (int i = 0; i < n; i++) {
            nums[i] += offset;
        }
        for (int i = 0; i < n; i++) {
            int first = i, idxOffset = (i + 1) * 10000;
            for (int j = i, nxt; nums[j] >= 0; j = nxt, first = nxt) {
                nxt = j + (nums[j] - offset);
                nxt = (nxt < 0 ? (1 - nxt / n) * n + nxt : nxt) % n;
                nums[j] = -nums[j] - idxOffset;
            }
            if (nums[first] / -10000 != i + 1) {
                continue;
            }
            int count = 0;
            boolean isPos = -idxOffset - nums[first] > offset, isLoop = true;
            for (int j = first, nxt = 0; j != first || count == 0; j = nxt, count++) {
                if ((-idxOffset - nums[j] > offset) != isPos) {
                    isLoop = false;
                    break;
                }
                nxt = j + (-idxOffset - nums[j] - offset);
                nxt = (nxt < 0 ? (1 - nxt / n) * n + nxt : nxt) % n;
            }
            if (count != 1 && isLoop) {
                return true;
            }
        }
        return false;
    }
}
