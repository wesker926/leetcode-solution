package com.wesker926.leetcode.algorithms.p0857.s1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/9/11
 * @description 排序 + 贪心 + 优先级队列
 * totalC / totalQ >= wage[i] / quality[i]
 * 变形：totalC >= totalQ * (wage[i] / quality[i])，当成本质量比最大时，不等式两边相等。
 * 因此选择一个工人，从比他成本质量比小的人中凑出最小totalQ，最后得到totalC。
 * 遍历每个工人，得到最小的totalC即为答案。
 */
public class Solution {
    @SuppressWarnings("all")
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);
        double ans = Double.MAX_VALUE, totalQ = 0;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalQ += quality[idxs[i]];
            queue.offer(quality[idxs[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            totalQ += quality[idxs[i]];
            queue.offer(quality[idxs[i]]);
            ans = Math.min(ans, totalQ * wage[idxs[i]] / quality[idxs[i]]);
            totalQ -= queue.poll();
        }
        return ans;
    }
}
