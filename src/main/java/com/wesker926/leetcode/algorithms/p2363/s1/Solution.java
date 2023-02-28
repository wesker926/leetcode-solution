package com.wesker926.leetcode.algorithms.p2363.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/2/28
 * @description 哈希表
 */
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] table = new int[1001];
        for (int[] item : items1) {
            table[item[0]] += item[1];
        }
        for (int[] item : items2) {
            table[item[0]] += item[1];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                ans.add(List.of(i, table[i]));
            }
        }
        return ans;
    }
}
