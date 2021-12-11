package com.wesker926.leetcode.algorithms.p0911.s1;

/**
 * @author wesker.gh
 * @date 2021/12/11
 * @description 遍历 + 桶哈希 + 二分
 */
public class Solution {

    int[][] record;

    public Solution(int[] persons, int[] times) {
        record = new int[times.length][2];
        int[] map = new int[5000];
        int max = 0;

        for (int i = 0; i < times.length; i++) {
            map[persons[i]]++;
            record[i][0] = times[i];
            record[i][1] = map[persons[i]] >= max ? persons[i] : record[i - 1][1];
            max = Math.max(max, map[persons[i]]);
        }
    }

    public int q(int t) {
        int l = 0, r = record.length - 1, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (record[m][0] == t) {
                return record[m][1];
            } else if (record[m][0] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r < 0 ? 0 : record[r][1];
    }
}
