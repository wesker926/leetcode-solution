package com.wesker926.leetcode.algorithms.p2034.s1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wesker.gh
 * @date 2022/1/23
 * @description 有序集合（树集）
 */
public class Solution {

    private int cur;

    private final Map<Integer, Integer> map;

    private final TreeMap<Integer, Integer> sort;

    /**
     * Your StockPrice object will be instantiated and called as such:
     * StockPrice obj = new StockPrice();
     * obj.update(timestamp,price);
     * int param_2 = obj.current();
     * int param_3 = obj.maximum();
     * int param_4 = obj.minimum();
     */
    public Solution() {
        cur = 0;
        map = new HashMap<>();
        sort = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        int prePrice = map.getOrDefault(timestamp, 0);
        if (prePrice == price) {
            return;
        }
        map.put(timestamp, price);
        cur = Math.max(cur, timestamp);

        if (prePrice > 0) {
            Integer preCount = sort.put(prePrice, sort.get(prePrice) - 1);
            if (preCount != null && preCount == 1) {
                sort.remove(prePrice);
            }
        }
        sort.put(price, sort.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.getOrDefault(cur, 0);
    }

    public int maximum() {
        return sort.lastKey();
    }

    public int minimum() {
        return sort.firstKey();
    }
}
