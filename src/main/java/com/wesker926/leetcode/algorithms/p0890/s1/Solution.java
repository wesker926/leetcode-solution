package com.wesker926.leetcode.algorithms.p0890.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/6/12
 * @description 哈希表双向映射
 */
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int[] table = new int[27];
            boolean isMatch = true;
            for (int i = 0; i < pattern.length(); i++) {
                int a = word.charAt(i) - 'a' + 1, b = pattern.charAt(i) - 'a' + 1;
                if ((table[a] & 31) == 0 && (table[b] >> 5) == 0) {
                    table[a] += b;
                    table[b] += a << 5;
                } else if ((table[a] & 31) != b || (table[b] >> 5) != a) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                ans.add(word);
            }
        }
        return ans;
    }
}
