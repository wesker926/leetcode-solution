package com.wesker926.leetcode.algorithms.p0522.s2;

/**
 * @author wesker.gh
 * @date 2022/6/27
 * @description 双指针
 * O(m*m*n)
 * 如果一个字符串包含特殊序列，那么它自身必然是特殊序列
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubSeq(strs[i], strs[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                max = Math.max(max, strs[i].length());
            }
        }
        return max;
    }

    private boolean isSubSeq(String a, String b) {
        int i = 0;
        for (int j = 0; i < a.length() && j < b.length(); j++) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
        }
        return i == a.length();
    }
}
