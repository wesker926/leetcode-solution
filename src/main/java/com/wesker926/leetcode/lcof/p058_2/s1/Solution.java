package com.wesker926.leetcode.lcof.p058_2.s1;

/**
 * @author wesker.gh
 * @date 2022/4/18
 * @description 翻转法（原地）
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] cs = s.toCharArray();
        reverse(cs, 0, n - 1);
        reverse(cs, n, cs.length - 1);
        reverse(cs, 0, cs.length - 1);
        return new String(cs);
    }

    private void reverse(char[] arr, int i, int j) {
        for (char t; i < j; i++, j--) {
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
