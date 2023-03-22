package com.wesker926.leetcode.algorithms.p1626.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2023/3/22
 * @description 排序 + DP + 树状数组
 * 必须要先排序才能DP，排序是进行问题转化的基础
 * DP思路可参考：主站-p0300 最长递增子序列，即以当前位置为终点来计算当前最优值，转移时需要遍历前面所有符合条件的值
 * 可以看到DP转移的开销较高，因此可使用数据结构来维护决策候选集合，降低时间复杂度，这里适合用树状数组，线段树
 * 树状数组：binary index tree，又称 fenwick tree
 * 其每个索引位置维护向前lowbit大小的区间
 * 比如6(110)维护2(10)大小的区间[5,6]
 * 8(1000)维护8(1000)大小的区间[1,8]
 * 因此每个从1开始的区间都可以用若干个索引来表示（需要索引的数量等于区间右断点二进制表示中1的个数）
 * 比如区间[1,11(1011)]可以用11(1011)，10(1010)，8(1000)来表示
 * 因为即可将区间读写降低为O(logN)复杂度
 */
public class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] people = new int[scores.length][2];
        for (int i = 0; i < people.length; i++) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int maxAge = 0;
        for (int[] person : people) {
            maxAge = Math.max(maxAge, person[1]);
        }
        BinaryIndexTree tree = new BinaryIndexTree(maxAge);

        int ans = 0;
        for (int[] person : people) {
            int cur = tree.query(person[1]) + person[0];
            ans = Math.max(ans, cur);
            tree.update(person[1], cur);
        }
        return ans;
    }

    private static class BinaryIndexTree {

        private final int[] arr;

        BinaryIndexTree(int n) {
            this.arr = new int[n + 1];
        }

        private void update(int idx, int val) {
            for (; idx < arr.length; idx += lowbit(idx)) {
                arr[idx] = Math.max(arr[idx], val);
            }
        }

        private int query(int idx) {
            int res = 0;
            for (; idx > 0; idx -= lowbit(idx)) {
                res = Math.max(res, arr[idx]);
            }
            return res;
        }

        private int lowbit(int x) {
            return x & (-x);
        }
    }
}
