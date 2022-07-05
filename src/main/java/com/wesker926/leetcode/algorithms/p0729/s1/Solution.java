package com.wesker926.leetcode.algorithms.p0729.s1;

import java.util.TreeMap;

/**
 * @author wesker.gh
 * @date 2022/7/5
 * @description TreeMap
 */
public class Solution {

    private final TreeMap<Integer, Integer> calendar;

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(start,end);
     */
    public Solution() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (calendar.isEmpty()) {
            calendar.put(start, end);
            return true;
        }

        Integer pre = calendar.lowerKey(start);
        if (pre != null && calendar.get(pre) > start) {
            return false;
        }

        Integer nxt = pre == null ? calendar.firstKey() : calendar.higherKey(pre);
        if (nxt != null && nxt < end) {
            return false;
        }

        calendar.put(start, end);
        return true;
    }
}
