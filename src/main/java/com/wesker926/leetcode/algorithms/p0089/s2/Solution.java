package com.wesker926.leetcode.algorithms.p0089.s2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/1/8
 * @description 异或法 i ^ (i >> 1)
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < (1 << n); i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}
