package com.wesker926.leetcode.algorithms.p0944.s1;

/**
 * @author wesker.gh
 * @date 2022/5/12
 * @description 遍历
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
