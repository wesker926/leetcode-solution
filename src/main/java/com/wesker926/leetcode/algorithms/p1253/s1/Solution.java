package com.wesker926.leetcode.algorithms.p1253.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/6/29
 * @description 贪心
 * 巨丑的代码，丑到idea检测错误
 */
public class Solution {
    @SuppressWarnings("all")
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[] count = new int[3], rowsum = new int[]{upper, lower};
        for (int col : colsum) count[col]++;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) if ((rowsum[i] -= count[2]) < 0) return ans;
        if (rowsum[0] + rowsum[1] != count[1]) return ans;
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
            for (int col : colsum) ans.get(i).add(col >> 1);
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] != 1) continue;
            int j = rowsum[0] > 0 ? 0 : 1;
            ans.get(j).set(i, 1);
            rowsum[j]--;
        }
        return ans;
    }
}
