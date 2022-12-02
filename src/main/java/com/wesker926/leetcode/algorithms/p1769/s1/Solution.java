package com.wesker926.leetcode.algorithms.p1769.s1;

/**
 * @author wesker.gh
 * @date 2022/12/2
 * @description 一次遍历
 * 可用前缀和数组，但其实用两个变量记录就够了
 */
public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), left = boxes.charAt(0) - '0', right = 0;
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                ans[0] += i;
                right++;
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] - right + left;
            if (boxes.charAt(i) == '1') {
                right--;
                left++;
            }
        }
        return ans;
    }
}
