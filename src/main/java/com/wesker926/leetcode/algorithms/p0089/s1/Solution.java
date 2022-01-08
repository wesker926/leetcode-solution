package com.wesker926.leetcode.algorithms.p0089.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/1/8
 * @description 镜像法
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>(1 << n);
        ans.add(0);
        ans.add(1);
        for (int i = 1; i < n; i++) {
            for (int c = 1 << i, j = c - 1; j >= 0; j--) {
                ans.add(ans.get(j) + c);
            }
        }
        return ans;
    }
}
