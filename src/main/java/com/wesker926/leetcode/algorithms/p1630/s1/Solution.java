package com.wesker926.leetcode.algorithms.p1630.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/3/23
 * @description 排序 + 遍历
 */
public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length, m = l.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(i -> nums[i]));

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boolean isValid = true;
            int pre = Integer.MIN_VALUE, diff = pre;
            for (int idx : index) {
                if (idx < l[i] || idx > r[i]) {
                    continue;
                }
                if (pre != Integer.MIN_VALUE) {
                    if (diff == Integer.MIN_VALUE) {
                        diff = nums[idx] - pre;
                    } else if (diff != nums[idx] - pre) {
                        isValid = false;
                        break;
                    }
                }
                pre = nums[idx];
            }
            ans.add(isValid);
        }
        return ans;
    }
}
