package com.wesker926.leetcode.algorithms.p2208.s1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2023/7/25
 * @description 堆
 * 更快的方法是搞一个排序数组，用一个更新一个，循环使用（当cur小于第一个时，从第一个重新开始循环）
 */
public class Solution {
    public int halveArray(int[] nums) {
        int ans = 0;
        double sum = 0;
        Queue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer((double) num);
            sum += num;
        }
        for (sum /= 2; sum > 0; ans++) {
            double cur = queue.poll() / 2;
            queue.offer(cur);
            sum -= cur;
        }
        return ans;
    }
}
