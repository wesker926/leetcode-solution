package com.wesker926.leetcode.lcof2.p115.s2;

/**
 * @author wesker.gh
 * @date 2022/7/23
 * @description 检查nums中邻接节点是否全在seq中存在
 * 外星人思路
 */
public class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] idxs = new int[n + 1];
        for (int i = 0; i < n; i++) {
            idxs[nums[i]] = i;
        }
        boolean[] adj = new boolean[n - 1];
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                if (idxs[sequence[i]] + 1 == idxs[sequence[i + 1]]) {
                    adj[idxs[sequence[i]]] = true;
                }
            }
        }
        for (boolean b : adj) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
