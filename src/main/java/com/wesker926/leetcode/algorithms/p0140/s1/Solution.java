package com.wesker926.leetcode.algorithms.p0140.s1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/5/23
 * @description DP（自底向上）
 * 因为即使不能拆分，依然会对每个下标进行大量匹配，所以非最优。
 * 自顶向下（记忆化搜索）可以剪枝，因此更快。
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<List<String>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new LinkedList<>());
        }
        dp.get(n).add("");
        List<String> cur, pre;
        for (int i = n - 1; i >= 0; i--) {
            cur = dp.get(i);
            String sub = s.substring(i, n);
            for (String word : wordDict) {
                if (!sub.startsWith(word) || (pre = dp.get(i + word.length())).isEmpty()) {
                    continue;
                }
                if (i + word.length() == n) {
                    cur.add(word);
                    continue;
                }
                for (String str : pre) {
                    cur.add(word + " " + str);
                }
            }
        }
        return dp.get(0);
    }
}
