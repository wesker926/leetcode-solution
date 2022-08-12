package com.wesker926.leetcode.algorithms.p1282.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/12
 * @description 遍历 + 哈希表（数组）
 */
public class Solution {
    @SuppressWarnings("all")
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List[] groups = new List[n + 1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int group = groupSizes[i];
            if (groups[group] == null) {
                groups[group] = new ArrayList<Integer>();
            }
            groups[group].add(i);
            if (groups[group].size() == group) {
                ans.add(groups[group]);
                groups[group] = null;
            }
        }
        return ans;
    }
}
