package com.wesker926.leetcode.algorithms.p0134.s1;

/**
 * @author wesker.gh
 * @date 2022/5/21
 * @description 遍历
 * 以gas[i]-cost[i]的sum画折线图，如果最后sum不小于0，则说明全程的油是够用的。
 * 如此，我们以sum的最低点的后一个站点出发，必然可以走完全程。
 * 否则，全程的油不够，肯定无法走完。
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = gas[0] - cost[0], min = sum, minIdx = 0;
        for (int i = 1; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                minIdx = i;
            }
        }
        return sum >= 0 ? (minIdx + 1) % gas.length : -1;
    }
}
