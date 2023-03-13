package com.wesker926.leetcode.algorithms.p2383.s1;

/**
 * @author wesker.gh
 * @date 2023/3/13
 * @description 模拟
 */
public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0, n = energy.length;
        for (int i = 0; i < n; i++) {
            int lackEnergy = Math.max(energy[i] - initialEnergy + 1, 0), lackExp = Math.max(experience[i] - initialExperience + 1, 0);
            initialEnergy += lackEnergy - energy[i];
            initialExperience += lackExp + experience[i];
            ans += lackEnergy + lackExp;
        }
        return ans;
    }
}
