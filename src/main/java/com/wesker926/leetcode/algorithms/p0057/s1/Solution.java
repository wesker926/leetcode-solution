package com.wesker926.leetcode.algorithms.p0057.s1;

import java.util.LinkedList;

/**
 * @author wesker.gh
 * @date 2022/5/1
 * @description 模拟
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        int idx = 0, n = intervals.length;
        for (; idx < n && intervals[idx][1] < newInterval[0]; idx++) ans.add(intervals[idx]);
        if (idx < n) newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
        for (; idx < n && intervals[idx][0] <= newInterval[1]; idx++)
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
        for (ans.add(newInterval); idx < n; idx++) ans.add(intervals[idx]);
        return ans.toArray(new int[ans.size()][]);
    }
}
