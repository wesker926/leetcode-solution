package com.wesker926.leetcode.algorithms.p0731.s1;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wesker.gh
 * @date 2022/7/19
 * @description 有序列表
 * 这题主流解法是：
 * 1.差分数组O(n^2)
 * 2.线段树O(nlogC)
 */
public class Solution {

    private final TreeMap<Integer, Integer> calendar;

    /**
     * Your MyCalendarTwo object will be instantiated and called as such:
     * MyCalendarTwo obj = new MyCalendarTwo();
     * boolean param_1 = obj.book(start,end);
     */
    public Solution() {
        calendar = new TreeMap<>();
        calendar.put(0, 0);
    }

    public boolean book(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : calendar.tailMap(calendar.lowerKey(start + 1)).entrySet()) {
            if (entry.getKey() >= end) {
                break;
            }
            if (entry.getValue() >= 2) {
                return false;
            }
        }

        int preLeftKey = calendar.lowerKey(start + 1);
        int preRightVal = calendar.get(calendar.lowerKey(end + 1));
        if (preLeftKey != start) {
            calendar.put(start, calendar.get(preLeftKey));
        }

        for (Map.Entry<Integer, Integer> entry : calendar.tailMap(start).entrySet()) {
            if (entry.getKey() >= end) {
                break;
            }
            entry.setValue(entry.getValue() + 1);
        }
        calendar.put(end, preRightVal);
        return true;
    }
}
