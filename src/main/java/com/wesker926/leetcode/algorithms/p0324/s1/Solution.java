package com.wesker926.leetcode.algorithms.p0324.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 快速选择 + 分区 + 穿插
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int half = nums.length / 2;
        quickSelect(nums, half);

        // 3-way-partition
        for (int i = 0, j = 0, k = nums.length - 1, m = nums[half]; j < k; ) {
            if (nums[j] < m) {
                swap(nums, i++, j++);
            } else if (nums[j] > m) {
                swap(nums, j, k--);
            } else {
                j++;
            }
        }

        // partition reverse copy
        if ((nums.length & 1) == 1) {
            half++;
        }
        int[] part1 = new int[half], part2 = new int[nums.length - half];
        System.arraycopy(nums, 0, part1, 0, half);
        System.arraycopy(nums, half, part2, 0, nums.length - half);

        // insert
        for (int i = 0; i < part1.length; i++) {
            nums[i * 2] = part1[part1.length - 1 - i];
        }
        for (int i = 0; i < part2.length; i++) {
            nums[i * 2 + 1] = part2[part2.length - 1 - i];
        }
    }

    private void quickSelect(int[] nums, int t) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = partition(nums, l, r);
            if (m == t) {
                return;
            } else if (m > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }

    private int partition(int[] nums, int s, int e) {
        swap(nums, (int) (Math.random() * (e - s + 1)) + s, e);
        int i = s;
        for (int j = s; j <= e; j++) {
            if (nums[j] <= nums[e]) {
                swap(nums, i++, j);
            }
        }
        return i - 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
