package com.wesker926.leetcode.algorithms.p0795.s2;

/**
 * @author wesker.gh
 * @date 2022/11/24
 * @description 遍历
 * 固定子区间右端点为i，左端点的取值区间为(最近出现大于right的位置，最近出现不小于left的位置]
 * 因此需要维护上述左端点取值区间的两个指针
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                l = i;
            }
            if (nums[i] >= left) {
                r = i;
            }
            ans += r - l;
        }
        return ans;
    }
}
