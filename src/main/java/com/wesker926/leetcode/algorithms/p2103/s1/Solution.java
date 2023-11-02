package com.wesker926.leetcode.algorithms.p2103.s1;

/**
 * @author wesker.gh
 * @date 2023/11/2
 * @description 状态压缩
 * 可以做到O(1)空间：每个杆3bit，共30bit
 */
public class Solution {

    private static final int tar = 65569;

    public int countPoints(String rings) {
        int ans = 0;
        int[] rods = new int[10];
        for (int i = 0; i < rings.length(); i += 2) {
            int rod = rings.charAt(i + 1) - '0', color = rings.charAt(i) - 'B';
            if (rods[rod] == tar) continue;
            if ((rods[rod] |= (1 << color)) == tar) ans++;
        }
        return ans;
    }
}
