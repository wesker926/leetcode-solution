package com.wesker926.leetcode.algorithms.p1419.s3;

/**
 * @author wesker.gh
 * @date 2023/5/6
 * @description 计数
 * 以阶段的视角来看数组，循环利用位于初始位置的青蛙
 */
public class Solution {

    private static final int[] IDX = new int[]{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 1};

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] step = new int[5];
        for (char ch : croakOfFrogs.toCharArray()) {
            int idx = IDX[ch - 'a'];
            if (idx == 0 && step[0] == 0) step[0]++;
            if (--step[idx] < 0) return -1;
            if (++idx == 5) idx = 0;
            step[idx]++;
        }
        return step[1] != 0 || step[2] != 0 || step[3] != 0 || step[4] != 0 ? -1 : step[0];
    }
}
