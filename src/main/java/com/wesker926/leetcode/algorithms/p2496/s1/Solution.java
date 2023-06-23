package com.wesker926.leetcode.algorithms.p2496.s1;

/**
 * @author wesker.gh
 * @date 2023/6/23
 * @description 遍历
 */
public class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            int num = 0;
            for (char ch : str.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    num = str.length();
                    break;
                }
                num = num * 10 + (ch - '0');
            }
            max = Math.max(max, num);
        }
        return max;
    }
}
