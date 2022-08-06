package com.wesker926.leetcode.algorithms.p1408.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/6
 * @description 暴力枚举
 */
public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
