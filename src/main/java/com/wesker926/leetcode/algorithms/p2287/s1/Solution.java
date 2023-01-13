package com.wesker926.leetcode.algorithms.p2287.s1;

/**
 * @author wesker.gh
 * @date 2023/1/13
 * @description 哈希
 */
public class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[][] bucket = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a'][0]++;
        }
        for (int i = 0; i < target.length(); i++) {
            bucket[target.charAt(i) - 'a'][1]++;
        }
        int ans = s.length();
        for (int[] cnt : bucket) {
            if (cnt[1] != 0) {
                ans = Math.min(ans, cnt[0] / cnt[1]);
            }
        }
        return ans;
    }
}
