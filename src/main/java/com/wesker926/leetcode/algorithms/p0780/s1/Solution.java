package com.wesker926.leetcode.algorithms.p0780.s1;

/**
 * @author wesker.gh
 * @date 2022/4/9
 * @description 倒序取模
 */
public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx > ty) {
                if (sy == ty && (tx - sx) % sy == 0) {
                    return true;
                }
                tx %= ty;
            } else if (ty > tx) {
                if (sx == tx && (ty - sy) % sx == 0) {
                    return true;
                }
                ty %= tx;
            } else {
                return sx == tx && sy == ty;
            }
        }
        return false;
    }
}
