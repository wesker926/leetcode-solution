package com.wesker926.leetcode.algorithms.p1450.s1;

/**
 * @author wesker.gh
 * @date 2022/8/19
 * @description 遍历
 * 这题可以用差分数组（多次查询和小time占优）和二分（思路比较有创意）
 */
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }
}
