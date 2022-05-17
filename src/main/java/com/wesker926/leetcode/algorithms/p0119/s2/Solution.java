package com.wesker926.leetcode.algorithms.p0119.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/17
 * @description 数学
 * 组合数Cmn = n!/m!/(n-m)!
 * 杨辉三角每一行的每一项是一个组合数Cmn，n，m从0开始。
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.add((int) ((long) ans.get(i - 1) * (rowIndex + 1 - i) / i));
        }
        return ans;
    }
}
