package com.wesker926.leetcode.algorithms.p0952.s1;

/**
 * @author wesker.gh
 * @date 2022/7/30
 * @description 因子分解 + 并查集
 * 并查集应用
 */
public class Solution {
    public int largestComponentSize(int[] nums) {
        int max = nums[0], ans = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        UnionFind union = new UnionFind(max + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    union.union(num, i);
                    union.union(num, num / i);
                }
            }
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            ans = Math.max(ans, ++count[union.find(num)]);
        }
        return ans;
    }

    private static class UnionFind {

        private final int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int i, int j) {
            int pi = find(i), pj = find(j);
            if (pi == pj) {
                return;
            }
            parent[pi] = pj;
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
}
