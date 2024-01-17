package com.wesker926.leetcode.algorithms.p2744.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2024/1/17
 * @description 哈希表
 * 没读题的写法。实际上题目约束了字符串长度为2 & 字符串互不相同，并且数据最大50个。因此可以直接双重循环来做。
 */
public class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        Map<String, Integer> m = new HashMap<>();
        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            int cnt = m.getOrDefault(reverse, 0);
            if (cnt <= 0) m.put(word, m.getOrDefault(word, 0) + 1);
            else {
                m.put(reverse, cnt - 1);
                res++;
            }
        }
        return res;
    }
}
