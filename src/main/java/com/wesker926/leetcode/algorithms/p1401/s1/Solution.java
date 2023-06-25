package com.wesker926.leetcode.algorithms.p1401.s1;

/**
 * @author wesker.gh
 * @date 2023/6/25
 * @description 数学
 * 这题不需要旋转象限
 * https://leetcode.cn/problems/circle-and-rectangle-overlapping/solutions/2293443/yuan-he-ju-xing-shi-fou-you-zhong-die-by-zlbk/
 */
public class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (x1 > xCenter + radius || xCenter - radius > x2 || y1 > yCenter + radius || yCenter - radius > y2)
            return false;
        if ((x1 <= xCenter && x2 >= xCenter) || (y1 <= yCenter && y2 >= yCenter)) return true;
        int x = x1 > xCenter ? x1 : x2;
        int y = y1 > yCenter ? y1 : y2;
        return Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2) <= Math.pow(radius, 2);
    }
}
