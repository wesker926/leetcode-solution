package com.wesker926.leetcode.algorithms.p0119.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description 记忆化搜索
 */
public class Solution {

    private static int n = 1;

    private static final List<List<Integer>> MEMORY = new ArrayList<>(List.of(List.of(1)));

    public List<Integer> getRow(int rowIndex) {
        for (; n <= rowIndex; n++) {
            List<Integer> cur = new ArrayList<>(n + 1);
            cur.add(1);
            for (int i = 1; i < n; i++) {
                cur.add(MEMORY.get(n - 1).get(i - 1) + MEMORY.get(n - 1).get(i));
            }
            cur.add(1);
            MEMORY.add(cur);
        }
        return MEMORY.get(rowIndex);
    }
}
