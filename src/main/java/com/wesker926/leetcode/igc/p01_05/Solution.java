package com.wesker926.leetcode.igc.p01_05;

/**
 * @author wesker.gh
 * @date 2022/5/13
 * @description 双指针
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first.length() < second.length()) {
            return oneEditAway(second, first);
        }
        if (first.length() - second.length() > 1) {
            return false;
        }
        int diff = 0;
        for (int i = 0, j = 0; i < first.length(); i++) {
            if (j < second.length() && first.charAt(i) == second.charAt(j)) {
                j++;
            } else {
                diff++;
                if (first.length() == second.length()) {
                    j++;
                }
            }
        }
        return diff <= 1;
    }
}
