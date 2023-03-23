package com.wesker926.leetcode.algorithms.p1630.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/3/23
 * @description 遍历检查
 * 利用等差的数学特性进行检查，本质上是把排序换成了桶
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            ans.add(check(nums, l[i], r[i]));
        }
        return ans;
    }

    private boolean check(int[] nums, int l, int r) {
        int max = nums[l], min = nums[l];
        for (int i = l + 1; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min) {
            return true;
        }
        if ((max - min) % (r - l) != 0) {
            return false;
        }
        int diff = (max - min) / (r - l);
        boolean[] seq = new boolean[r - l + 1];
        for (int i = l; i <= r; i++) {
            if ((nums[i] - min) % diff != 0) {
                return false;
            }
            int cur = (nums[i] - min) / diff;
            if (seq[cur]) {
                return false;
            }
            seq[cur] = true;
        }
        return true;
    }
}
