package com.wesker926.leetcode.algorithms.p0791.s2;

/**
 * @author wesker.gh
 * @date 2022/11/13
 * @description 计数排序
 * 只有26个字母，可以用计数排序
 */
public class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            sb.append(String.valueOf(c).repeat(count[c - 'a']));
            count[c - 'a'] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            sb.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
        }
        return sb.toString();
    }
}
