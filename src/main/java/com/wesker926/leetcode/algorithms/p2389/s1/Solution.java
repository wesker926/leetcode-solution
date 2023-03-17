package com.wesker926.leetcode.algorithms.p2389.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/3/17
 * @description 排序 + 前缀和 + 二分
 */
public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = binary(pre, queries[i]);
        }
        return ans;
    }

    private int binary(int[] arr, int t) {
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] <= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
