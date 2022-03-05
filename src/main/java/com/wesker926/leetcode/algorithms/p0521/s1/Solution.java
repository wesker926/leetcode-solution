package com.wesker926.leetcode.algorithms.p0521.s1;

/**
 * @author wesker.gh
 * @date 2022/3/5
 * @description 脑筋急转弯
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
