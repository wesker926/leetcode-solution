package com.wesker926.leetcode.algorithms.p0611.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/9/29
 * @description 排序 + 三指针
 * 把内层循环转换为双指针O(n)遍历
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    ans += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}
