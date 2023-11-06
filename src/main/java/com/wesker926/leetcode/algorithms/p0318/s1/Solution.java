package com.wesker926.leetcode.algorithms.p0318.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2021/11/17
 * @description 主要考察字符串的bit表示
 */
public class Solution {
    public int maxProduct(String[] words) {
        int ans = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (String word : words) {
            int key = 0, len = word.length();
            for (char ch : word.toCharArray()) key |= 1 << (ch - 'a');
            if (!m.containsKey(key) || m.get(key) < len) m.put(key, len);
        }
        for (int k1 : m.keySet()) {
            for (int k2 : m.keySet()) {
                if ((k1 & k2) == 0) ans = Math.max(ans, m.get(k1) * m.get(k2));
            }
        }
        return ans;
    }
}
