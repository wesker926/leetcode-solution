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
        int idx = 0;
        for (; idx < intervals.length && intervals[idx][1] < newInterval[0]; idx++) {
            ans.add(intervals[idx]);
        }
        if (idx == intervals.length || intervals[idx][0] >= newInterval[0]) {
            ans.add(newInterval);
        } else {
            ans.add(intervals[idx]);
            intervals[idx] = newInterval;
        }
        for (; idx < intervals.length; idx++) {
            if (intervals[idx][0] <= ans.getLast()[1]) {
                ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[idx][1]);
            } else {
                ans.add(intervals[idx]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
