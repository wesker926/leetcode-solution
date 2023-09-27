package com.wesker926.leetcode.algorithms.p1333.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/9/27
 * @description 排序
 */
public class Solution {
    public List<Integer> filterRestaurants(int[][] rs, int v, int p, int d) {
        List<Integer> sortList = new ArrayList<>(), ans = new ArrayList<>();
        for (int i = 0; i < rs.length; i++)
            if (rs[i][2] >= v && rs[i][3] <= p && rs[i][4] <= d) sortList.add(i);
        sortList.sort((i, j) -> rs[j][1] != rs[i][1] ? rs[j][1] - rs[i][1] : rs[j][0] - rs[i][0]);
        for (int idx : sortList) ans.add(rs[idx][0]);
        return ans;
    }
}
