package com.wesker926.leetcode.algorithms.p2347.s1;

/**
 * @author wesker.gh
 * @date 2023/2/20
 * @description 哈希表
 */
public class Solution {

    private static final String[] TYPES = new String[]{"Flush", "High Card", "Pair", "Three of a Kind"};

    public String bestHand(int[] ranks, char[] suits) {
        int maxRC = 0, maxSC = 0;
        int[] table = new int[17];
        for (int i = 0; i < 5; i++) {
            table[ranks[i] - 1]++;
            table[suits[i] - 84]++;
            maxRC = Math.max(maxRC, table[ranks[i] - 1]);
            maxSC = Math.max(maxSC, table[suits[i] - 84]);
        }
        return TYPES[maxSC == 5 ? 0 : Math.min(maxRC, 3)];
    }
}
