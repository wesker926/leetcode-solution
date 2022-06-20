package com.wesker926.leetcode.algorithms.p0715.s1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wesker.gh
 * @date 2022/6/20
 * @description 有序列表（线段树）
 */
public class Solution {

    private static final int RIGHT_LIMIT = (int) 1e9 + 1;

    private final TreeMap<Integer, Boolean> map;

    public Solution() {
        map = new TreeMap<>();
        map.put(0, false);
        map.put(RIGHT_LIMIT, false);
    }

    public void addRange(int left, int right) {
        modifyRange(left, right, true);
    }

    public boolean queryRange(int left, int right) {
        if (!map.containsKey(left) && !map.get(map.lowerKey(left))) {
            return false;
        }
        for (Map.Entry<Integer, Boolean> entry : map.tailMap(left).entrySet()) {
            if (entry.getKey() >= right) {
                break;
            }
            if (!entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void removeRange(int left, int right) {
        modifyRange(left, right, false);
    }

    private void modifyRange(int left, int right, boolean val) {
        int stop = RIGHT_LIMIT;
        List<Integer> delete = new ArrayList<>();
        boolean preLeftVal = map.get(map.lowerKey(left));
        boolean preRightVal = map.get(map.lowerKey(right));
        for (Map.Entry<Integer, Boolean> entry : map.tailMap(left).entrySet()) {
            if (entry.getKey() >= right) {
                stop = entry.getKey();
                break;
            }
            delete.add(entry.getKey());
        }
        for (int key : delete) {
            map.remove(key);
        }
        if (preLeftVal != val) {
            map.put(left, val);
        }
        if (stop != right) {
            map.put(right, preRightVal);
        }

        delete.clear();
        for (Map.Entry<Integer, Boolean> entry : map.tailMap(right).entrySet()) {
            if (entry.getKey() == RIGHT_LIMIT || entry.getValue() != val) {
                break;
            }
            delete.add(entry.getKey());
        }
        for (Integer key : delete) {
            map.remove(key);
        }
    }
}
