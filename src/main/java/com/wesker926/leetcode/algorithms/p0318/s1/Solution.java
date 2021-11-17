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
        int bit, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            bit = 0;
            for (char c : w.toCharArray()) {
                bit |= (1 << (c - 'a'));
            }
            map.put(bit, Math.max(map.getOrDefault(bit, 0), w.length()));
        }

        for (Map.Entry<Integer, Integer> e1 : map.entrySet()) {
            for (Map.Entry<Integer, Integer> e2 : map.entrySet()) {
                max = Math.max(max, (e1.getKey() & e2.getKey()) != 0 ? 0 : e1.getValue() * e2.getValue());
            }
        }
        return max;
    }
}
