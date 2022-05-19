package com.wesker926.leetcode.algorithms.p0462.s2;

/**
 * @author wesker.gh
 * @date 2022/5/19
 * @description 中位数（快速选择）
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int ans = 0, mid = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        for (int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }

    private int quickSelect(int[] nums, int l, int r, int t) {
        int q = partition(nums, l, r);
        return q == t ? nums[t] : (q < t ? quickSelect(nums, q + 1, r, t) : quickSelect(nums, l, q - 1, t));
    }

    private int partition(int[] nums, int l, int r) {
        // 如果不随机化，测试case极端情况下会很慢。
        swap(nums, r, l + (int) (Math.random() * (r - l)));
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= nums[r]) {
                swap(nums, i, idx++);
            }
        }
        return idx - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
