package com.wesker926.leetcode.algorithms.p1620.s1;

/**
 * @author wesker.gh
 * @date 2022/11/2
 * @description 遍历模拟
 * 1.最好的信号只会在[min,max]坐标间产生
 * 2.如果全都没信号，需要返回[0,0]
 */
public class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX = -1, maxY = -1, minX = 51, minY = 51;
        for (int[] tower : towers) {
            maxX = Math.max(maxX, tower[0]);
            minX = Math.min(minX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
            minY = Math.min(minY, tower[1]);
        }
        int ansX = 0, anxY = 0, max = -1;
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int cur = 0;
                for (int[] tower : towers) {
                    double d = Math.sqrt(Math.pow(tower[0] - i, 2) + Math.pow(tower[1] - j, 2));
                    cur += d <= radius ? Math.floor(tower[2] / (1 + d)) : 0;
                }
                if (cur > max) {
                    max = cur;
                    ansX = i;
                    anxY = j;
                }
            }
        }
        return max == 0 ? new int[]{0, 0} : new int[]{ansX, anxY};
    }
}
