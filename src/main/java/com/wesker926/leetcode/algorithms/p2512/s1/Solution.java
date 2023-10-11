package com.wesker926.leetcode.algorithms.p2512.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/10/11
 * @description 堆
 * 显然，效果不好
 */
public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback)), neg = new HashSet<>(Arrays.asList(negative_feedback));
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int i = 0; i < report.length; i++) {
            int[] cur = new int[]{0, student_id[i]};
            for (String s : report[i].trim().split(" ")) {
                if (pos.contains(s)) cur[0] += 3;
                else if (neg.contains(s)) cur[0]--;
            }
            queue.offer(cur);
            if (queue.size() > k) queue.poll();
        }
        Integer[] ans = new Integer[k];
        for (int i = k - 1; i >= 0 && !queue.isEmpty(); i--) ans[i] = queue.poll()[1];
        return Arrays.asList(ans);
    }
}
