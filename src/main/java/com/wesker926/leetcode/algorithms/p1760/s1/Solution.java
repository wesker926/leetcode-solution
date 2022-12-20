package com.wesker926.leetcode.algorithms.p1760.s1;

/**
 * @author wesker.gh
 * @date 2022/12/20
 * @description 二分
 * 最大值最小化，最小值最大化，可以看做二分的代名词
 * 因为这类问题，一般target越小，所需操作就越多，所以具备了单调性，而单调性问题基本就可以用二分来解决
 */
public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0, m;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(nums, maxOperations, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int operations, int target) {
        for (int i = 0; i < nums.length && operations >= 0; i++) {
            operations -= (nums[i] - 1) / target;
        }
        return operations >= 0;
    }
}
