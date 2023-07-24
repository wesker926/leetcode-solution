package com.wesker926.leetcode.algorithms.p0771.s1;

/**
 * @author wesker.gh
 * @date 2023/7/24
 * @description 遍历
 */
public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        boolean[] table = new boolean[128];
        for (char c : jewels.toCharArray()) table[c] = true;
        for (char c : stones.toCharArray()) if (table[c]) ans++;
        return ans;
    }
}
