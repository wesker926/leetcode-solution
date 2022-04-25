package com.wesker926.leetcode.algorithms.p0016.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 排序 + 三指针
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2], sum, n = nums.length;
        if (n == 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = n - 1; j < k; ) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum < target) {
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else {
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                }
            }
        }
        return ans;
    }
}
