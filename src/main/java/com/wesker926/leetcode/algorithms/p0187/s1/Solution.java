package com.wesker926.leetcode.algorithms.p0187.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/11/5
 * @description 滑动窗口（滚动哈希）
 */
public class Solution {

    private static final int[] MAPPING = new int[]{0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<Integer, Integer> appeared = new HashMap<>();
        for (int i = 0, cur = 0; i < s.length(); i++) {
            cur = (cur << 2 & 0xfffff) + MAPPING[s.charAt(i) - 'A'];
            if (i < 9) continue;
            int cnt = appeared.getOrDefault(cur, 0);
            if (cnt == 1) ans.add(s.substring(i - 9, i + 1));
            appeared.put(cur, cnt + 1);
        }
        return ans;
    }
}
