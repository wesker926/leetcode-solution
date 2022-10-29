package com.wesker926.leetcode.algorithms.p1773.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/29
 * @description 模拟遍历
 */
public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int rule = "type".equals(ruleKey) ? 0 : ("color".equals(ruleKey) ? 1 : 2), ans = 0;
        for (List<String> item : items) {
            if (item.get(rule).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }
}
