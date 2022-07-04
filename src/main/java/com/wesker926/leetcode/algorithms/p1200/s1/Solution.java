package com.wesker926.leetcode.algorithms.p1200.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/7/4
 * @description 排序遍历
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1, min = arr[1] - arr[0]; i < arr.length; i++) {
            int cur = arr[i] - arr[i - 1];
            if (cur > min) {
                continue;
            } else if (cur < min) {
                min = cur;
                ans.clear();
            }
            ans.add(List.of(arr[i - 1], arr[i]));
        }
        return ans;
    }
}
