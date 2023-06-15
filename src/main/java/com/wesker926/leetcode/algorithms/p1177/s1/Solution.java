package com.wesker926.leetcode.algorithms.p1177.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2023/6/15
 * @description 前缀和 + 位运算
 * 注意题目说可以重新排列
 * 统计区间内字母的奇偶性（非数量）可以用异或位运算
 */
public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[] p = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) p[i + 1] = p[i] ^ (1 << (s.charAt(i) - 'a'));
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries)
            ans.add(q[2] >= (Integer.bitCount(p[q[0]] ^ p[q[1] + 1]) >> 1));
        return ans;
    }
}
