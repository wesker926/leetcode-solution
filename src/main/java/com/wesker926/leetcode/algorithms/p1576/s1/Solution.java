package com.wesker926.leetcode.algorithms.p1576.s1;

/**
 * @author wesker.gh
 * @date 2022/1/5
 * @description 遍历 + 替换
 */
public class Solution {
    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '?') {
                continue;
            }

            for (char r = 'a'; r < 'd'; r++) {
                if ((i != 0 && cs[i - 1] == r) || (i != cs.length - 1 && cs[i + 1] == r)) {
                    continue;
                }
                cs[i] = r;
                break;
            }
        }
        return new String(cs);
    }
}
