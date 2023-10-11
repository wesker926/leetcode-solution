package com.wesker926.leetcode.algorithms.p2512.s2;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2023/10/11
 * @description 计数排序
 */
public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback)), neg = new HashSet<>(Arrays.asList(negative_feedback));
        List<Integer>[] scores = new List[201];
        for (int i = 0, score = 50; i < report.length; i++, score = 50) {
            for (String s : report[i].trim().split(" ")) {
                if (pos.contains(s)) score += 3;
                else if (neg.contains(s)) score--;
            }
            if (scores[score] == null) scores[score] = new ArrayList<>();
            scores[score].add(student_id[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 200; i >= 0; i--) {
            if (scores[i] == null) continue;
            if (scores[i].size() > 1) Collections.sort(scores[i]);
            for (int id : scores[i]) {
                ans.add(id);
                if (ans.size() >= k) return ans;
            }
        }
        return ans;
    }
}
