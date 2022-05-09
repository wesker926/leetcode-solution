package com.wesker926.leetcode.algorithms.p0942.s1;

/**
 * @author wesker.gh
 * @date 2022/5/9
 * @description 贪心
 * 如果升序就添加min，否则添加max，然后缩小规模。
 */
public class Solution {
    public int[] diStringMatch(String s) {
        char[] cs = s.toCharArray();
        int[] ans = new int[cs.length + 1];
        int max = cs.length, min = 0;
        for (int i = 0; i < cs.length; i++) {
            ans[i] = cs[i] == 'I' ? min++ : max--;
        }
        ans[cs.length] = min;
        return ans;
    }
}
