package com.wesker926.leetcode.algorithms.p0745.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2022/7/14
 * @description 暴力枚举所有前后缀组合
 * 2022.07.14时，当前测试用例可通过。
 * 也可以只枚举前缀，存列表，查询时比较后缀（当前提交中最快写法）。
 */
public class Solution {

    private final Map<String, Integer> map;

    public Solution(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char[] cs = words[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                for (int k = cs.length - 1; k >= 0; k--) {
                    map.put(new String(cs, 0, j + 1) + "-" + new String(cs, k, cs.length - k), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "-" + suff, -1);
    }
}
