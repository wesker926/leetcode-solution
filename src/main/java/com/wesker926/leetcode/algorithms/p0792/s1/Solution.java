package com.wesker926.leetcode.algorithms.p0792.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/11/17
 * @description 二分
 * 时间复杂度：O(sum(word.length) * logN)
 */
public class Solution {
    @SuppressWarnings("all")
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] idxs = new List[26];
        for (int i = 0; i < idxs.length; i++) {
            idxs[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            idxs[s.charAt(i) - 'a'].add(i);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int ans = 0;
        outer:
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            for (int i = 0, t = -1; i < word.length(); i++) {
                t = binary(idxs[word.charAt(i) - 'a'], t);
                if (t < 0) {
                    continue outer;
                }
            }
            ans += entry.getValue();
        }
        return ans;
    }

    private int binary(List<Integer> list, int t) {
        int l = 0, r = list.size() - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (list.get(m) <= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l < list.size() ? list.get(l) : -1;
    }
}
