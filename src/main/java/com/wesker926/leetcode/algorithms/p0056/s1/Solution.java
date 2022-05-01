package com.wesker926.leetcode.algorithms.p0056.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 排序 + 双指针遍历
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0, j; i < intervals.length; i = j) {
            for (j = i + 1; j < intervals.length && intervals[j][0] <= intervals[i][1]; j++) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            }
            ans.add(intervals[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
