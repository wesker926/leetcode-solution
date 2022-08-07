package com.wesker926.leetcode.algorithms.p0636.s1;

import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/8/7
 * @description 栈
 */
public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int[][] stack = new int[logs.size()][];
        for (int i = 0, idx = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            int first = log.indexOf(':'), last = log.lastIndexOf(':');
            int cur = Integer.parseInt(log.substring(0, first));
            int timestamp = Integer.parseInt(log.substring(last + 1));
            if (log.charAt(first + 1) == 's') {
                stack[idx] = new int[]{timestamp, 0};
                if (idx != 0) {
                    stack[idx - 1][1] += timestamp - stack[idx - 1][0];
                }
                idx++;
            } else {
                idx--;
                ans[cur] += (timestamp - stack[idx][0] + 1) + stack[idx][1];
                if (idx != 0) {
                    stack[idx - 1][0] = timestamp + 1;
                }
            }
        }
        return ans;
    }
}
