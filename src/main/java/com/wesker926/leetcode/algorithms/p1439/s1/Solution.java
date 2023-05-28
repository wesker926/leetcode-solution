package com.wesker926.leetcode.algorithms.p1439.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/5/28
 * @description 堆 + 哈希
 * 更优的两种解法：
 * 1.堆归并，一行行归并，每轮都只保留k个。
 * 2.二分，使用递归求解和不大于m的组合数，更新l和r直到求出
 */
public class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length, seq = 0;
        Set<String> seen = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c[m]));
        int[] first = new int[m + 1];
        for (int[] row : mat) first[m] += row[0];
        queue.offer(first);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (!seen.add(getKey(cur))) continue;
            if ((++seq) == k) return cur[m];
            for (int i = 0; i < m; i++) {
                if (cur[i] >= n - 1) continue;
                int[] nxt = Arrays.copyOf(cur, m + 1);
                nxt[m] += mat[i][nxt[i] + 1] - mat[i][(nxt[i]++)];
                queue.offer(nxt);
            }
        }
        return 0;
    }

    private String getKey(int[] index) {
        char[] cs = new char[index.length - 1];
        for (int i = 0; i < cs.length; i++) cs[i] = (char) index[i];
        return new String(cs);
    }
}
