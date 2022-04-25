package com.wesker926.leetcode.algorithms.p0018.s1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 排序 + 四指针
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        if (n < 4) {
            return ans;
        }
        Arrays.sort(nums);
        long t = target, t1, t2;
        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            t1 = t - nums[i];
            if ((long) nums[i + 1] + nums[i + 2] + nums[i + 3] > t1) {
                break;
            }
            if ((long) nums[n - 1] + nums[n - 2] + nums[n - 3] < t1) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                t2 = t1 - nums[j];
                if (nums[j + 1] + nums[j + 2] > t2) {
                    break;
                }
                if (nums[n - 1] + nums[n - 2] < t2) {
                    continue;
                }
                for (int k = j + 1, l = n - 1, sum; k < l; ) {
                    sum = nums[k] + nums[l];
                    if (sum == t2) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                    if (sum <= t2) {
                        do {
                            k++;
                        } while (k < l && nums[k] == nums[k - 1]);
                    } else {
                        do {
                            l--;
                        } while (k < l && nums[l] == nums[l + 1]);
                    }
                }
            }
        }
        return ans;
    }
}
