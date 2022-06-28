package com.wesker926.leetcode.algorithms.p0324.s3;

/**
 * @author wesker.gh
 * @date 2022/6/28
 * @description 快速选择 + 下标映射 + 三路分区
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, half = (n - 1) / 2;
        quickSelect(nums, half);

        // 3-way-partition with trans idx
        for (int i = 0, j = 0, k = n - 1, m = nums[half]; j < k; ) {
            if (nums[transIdx(j, n)] < m) {
                swap(nums, transIdx(i++, n), transIdx(j++, n));
            } else if (nums[transIdx(j, n)] > m) {
                swap(nums, transIdx(j, n), transIdx(k--, n));
            } else {
                j++;
            }
        }
    }

    // 牛逼
    private int transIdx(int i, int n) {
        return (n * 2 - i * 2 - 1) % (n | 1);
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
