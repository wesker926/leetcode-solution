package com.wesker926.leetcode.algorithms.p0784.s2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/10/30
 * @description 枚举mask
 */
public class Solution {
    public List<String> letterCasePermutation(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < (1 << count); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = count - 1; j < s.length(); j++) {
                sb.append(!Character.isLetter(s.charAt(j)) || ((i >> k--) & 1) == 0 ?
                        Character.toLowerCase(s.charAt(j)) :
                        Character.toUpperCase(s.charAt(j)));
            }
            res.add(sb.toString());
        }
        return res;
    }
}
