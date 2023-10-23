package com.wesker926.leetcode.algorithms.p2678.s1;

/**
 * @author wesker.gh
 * @date 2023/10/23
 * @description 遍历
 */
public class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String d : details) if (d.charAt(11) * 10 + d.charAt(12) > 588) cnt++;
        return cnt;
    }
}
