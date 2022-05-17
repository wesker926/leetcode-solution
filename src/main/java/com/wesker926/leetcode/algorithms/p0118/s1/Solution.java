package com.wesker926.leetcode.algorithms.p0118.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description 数学
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        ans.add(List.of(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>(i);
            cur.add(1);
            for (int j = 1; j < i - 1; j++) {
                cur.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
