package com.wesker926.leetcode.algorithms.p0335.s1;

/**
 * @author wesker.gh
 * @date 2021/10/29
 * @description 螺旋判断
 */
public class Solution {

    public boolean isSelfCrossing(int[] distance) {
        if (distance.length <= 3) {
            return false;
        }

        // 大螺旋
        int i;
        for (i = 2; i < distance.length; i++) {
            if (distance[i] <= distance[i - 2]) {
                break;
            }
        }

        if (i >= distance.length - 1) {
            return false;
        }

        // 大螺旋转小螺旋
        int limit = distance[i - 1];
        if ((i >= 4 && distance[i] >= distance[i - 2] - distance[i - 4]) || (i == 3 && distance[i] == distance[i - 2])) {
            limit -= distance[i - 3];
        }

        if (distance[i + 1] >= limit) {
            return true;
        }

        for (i += 2; i < distance.length; i++) {
            if (distance[i] >= distance[i - 2]) {
                return true;
            }
        }

        return false;
    }
}
