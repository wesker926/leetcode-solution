package com.wesker926.leetcode.algorithms.p0556.s1;

/**
 * @author wesker.gh
 * @date 2022/7/3
 * @description 转换数组扫描
 * 参考 主站-p0031
 * 也可以只在整数上操作（找位，整数反转），将空间变为O(1)，并且可以不使用long
 * 太麻烦了就不写了
 */
public class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int len = nums.length, idx;
        for (idx = len - 2; idx >= 0 && nums[idx] >= nums[idx + 1]; idx--) {
        }
        if (idx < 0) {
            return -1;
        }
        swap(nums, idx, binary(nums, idx + 1, len - 1, nums[idx]));
        for (int i = idx + 1, j = len - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private int binary(char[] nums, int l, int r, int t) {
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] > t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
