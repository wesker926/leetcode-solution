package com.wesker926.leetcode.algorithms.p2336.s1;

import java.util.TreeSet;

/**
 * @author wesker.gh
 * @date 2023/11/29
 * @description 有序集合
 */
@SuppressWarnings("all")
public class Solution {

    private int min;

    private final TreeSet<Integer> set;

    public Solution() {
        min = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) return min++;
        return set.pollFirst();
    }

    public void addBack(int num) {
        if (num < min) set.add(num);
    }
}
