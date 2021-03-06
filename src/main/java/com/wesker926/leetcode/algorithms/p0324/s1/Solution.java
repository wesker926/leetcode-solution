package com.wesker926.leetcode.algorithms.p0324.s1;

/**
 * @author wesker.gh
 * @date 2022/6/14
 * @description 快速选择 + 三路分区 + 穿插
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, half = n / 2;
        quickSelect(nums, half);

        // 3-way-partition
        for (int i = 0, j = 0, k = n - 1, m = nums[half]; j < k; ) {
            if (nums[j] < m) {
                swap(nums, i++, j++);
            } else if (nums[j] > m) {
                swap(nums, j, k--);
            } else {
                j++;
            }
        }

        half = (n + 1) / 2;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);

        // insert
        for (int i = 0; half - 1 - i >= 0; i++) {
            nums[i * 2] = copy[half - 1 - i];
        }
        for (int i = 0; n - 1 - i >= half; i++) {
            nums[i * 2 + 1] = copy[n - 1 - i];
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
