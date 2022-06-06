package com.wesker926.leetcode.algorithms.p0732.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/6/6
 * @description 有序集合
 * 仿主站-p0699
 */
public class Solution {

    private int lastMax = 0;

    private final TreeMap<Integer, Integer> calendar;

    public Solution() {
        calendar = new TreeMap<>();
        calendar.put(0, 0);
    }

    public int book(int start, int end) {
        end--;
        Integer left = calendar.higherKey(start), right = calendar.higherKey(end);
        Integer preLeft = left != null ? calendar.lowerKey(left) : calendar.lastKey();
        int preLeftVal = preLeft != null ? calendar.get(preLeft) : 0;
        Integer preRight = right != null ? calendar.lowerKey(right) : calendar.lastKey();
        int preRightVal = preRight != null ? calendar.get(preRight) : 0;

        Map<Integer, Integer> tailMap = calendar.tailMap(start, false);
        for (Map.Entry<Integer, Integer> entry : tailMap.entrySet()) {
            if (right != null && right.equals(entry.getKey())) {
                break;
            }
            entry.setValue(entry.getValue() + 1);
            lastMax = Math.max(lastMax, entry.getValue());
        }

        calendar.put(start, preLeftVal + 1);
        lastMax = Math.max(lastMax, calendar.get(start));
        if (right == null || right != end + 1) {
            calendar.put(end + 1, preRightVal);
        }

        return lastMax;
    }
}
