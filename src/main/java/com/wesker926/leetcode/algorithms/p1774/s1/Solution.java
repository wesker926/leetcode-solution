package com.wesker926.leetcode.algorithms.p1774.s1;

/**
 * @author wesker.gh
 * @date 2022/12/4
 * @description DP
 * 这题可以用回溯来做，但DP更优
 * 因为是关于某种开销是否存在制作方案的问题，因此可以转化为01背包问题
 */
public class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] can = new boolean[target];
        int min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int cost : baseCosts) {
            min = Math.min(min, cost);
            if (cost < target) {
                can[cost] = true;
            } else {
                res = Math.min(res, cost);
            }
        }
        if (min >= target || res == target) {
            return res;
        }
        res = Math.min(res, target * 2 - min);

        for (int cost : toppingCosts) {
            for (int c = 0; c < 2; c++) {
                for (int i = target - 1; i >= 0; i--) {
                    if (!can[i]) {
                        continue;
                    }
                    if (i + cost == target) {
                        return target;
                    } else if (i + cost > target) {
                        res = Math.min(res, i + cost);
                    } else {
                        can[i + cost] = true;
                    }
                }
            }
        }
        for (int i = target - 1; i >= target * 2 - res; i--) {
            if (can[i]) {
                return i;
            }
        }
        return res;
    }
}
