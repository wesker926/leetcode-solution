package com.wesker926.leetcode.algorithms.p1260.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/7/20
 * @description 一维坐标顺序写入
 * 还可以先展开成一维再写入
 * 如果返回数组的话，可直接遍历映射写入
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, total = m * n;
        k = (total - (k % total)) % total;
        List<List<Integer>> ans = new ArrayList<>(m);
        List<Integer> cur = new ArrayList<>(n);
        ans.add(cur);
        for (int count = 0, idx = k; count < total; count++, idx = (idx + 1) % total) {
            if (cur.size() == n) {
                cur = new ArrayList<>(n);
                ans.add(cur);
            }
            cur.add(grid[idx / n][idx % n]);
        }
        return ans;
    }
}
