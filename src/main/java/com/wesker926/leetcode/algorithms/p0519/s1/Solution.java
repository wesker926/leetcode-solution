package com.wesker926.leetcode.algorithms.p0519.s1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author wesker.gh
 * @date 2021/11/27
 * @description 哈希空位映射
 */
public class Solution {

    private final Random random;

    private final int m, n;

    private final Map<Integer, Integer> map;

    private int size;

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(m, n);
     * int[] param_1 = obj.flip();
     * obj.reset();
     */
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        random = new Random();
        size = m * n;
        map = new HashMap<>();
    }

    public int[] flip() {
        int idx = random.nextInt(size);
        size--;

        int realIdx = map.getOrDefault(idx, idx);
        map.put(idx, map.getOrDefault(size, size));
        return new int[]{realIdx / n, realIdx % n};
    }

    public void reset() {
        size = m * n;
        map.clear();
    }
}
