package com.wesker926.leetcode.algorithms.p0621.s2;

/**
 * @author wesker.gh
 * @date 2022/5/30
 * @description 列填充
 * 如果需要填充的列超过了n+1个，那么即使不使用空闲位，直接顺序执行也可以满足要求，此时所需时间为任务总数
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char task : tasks) {
            int idx = task - 'A';
            taskCount[idx]++;
        }
        int max = 0, maxCount = 0;
        for (int count : taskCount) {
            if (count > max) {
                max = count;
                maxCount = 1;
            } else if (count == max) {
                maxCount++;
            }
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}
