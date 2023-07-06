package com.wesker926.leetcode.algorithms.p2178.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/7/6
 * @description 贪心
 */
public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if ((finalSum & 1) != 0) return ans;
        for (long i = 2; i * 2 < finalSum; finalSum -= i, i += 2) ans.add(i);
        ans.add(finalSum);
        return ans;
    }
}
