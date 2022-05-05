package com.wesker926.leetcode.algorithms.p0077.s2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/5
 * @description 字典序法
 * 所有位左对齐，直到找到第一个向后gap的数字加一
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[k + 1];
        for (int i = 0; i < k; i++) {
            nums[i] = i + 1;
        }
        nums[k] = n + 1;
        List<List<Integer>> ans = new LinkedList<>();
        for (boolean has = true; has; ) {
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                temp.add(nums[i]);
            }
            ans.add(temp);
            has = false;
            for (int i = 0; i < k; i++) {
                if (nums[i] + 1 != nums[i + 1]) {
                    nums[i]++;
                    has = true;
                    break;
                }
                nums[i] = i + 1;
            }
        }
        return ans;
    }
}
