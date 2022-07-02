package com.wesker926.leetcode.lcp.p030.s1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wesker.gh
 * @date 2022/7/2
 * @description 贪心
 * 走到血量负数的时候，回过头把扣血最多的后移
 * 这题描述不太清，对于血量为0时的判断需要观察
 * 注意数据规模，需要long型
 * 和 主站-p0871 思路相同
 */
public class Solution {
    public int magicTower(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }

        int ans = 0;
        long cur = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            cur += num;
            if (num < 0) {
                queue.offer(num);
            }
            if (cur <= 0) {
                cur -= queue.poll();
                ans++;
            }
        }
        return ans;
    }
}
