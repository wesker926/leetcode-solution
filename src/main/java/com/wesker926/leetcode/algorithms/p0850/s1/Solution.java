package com.wesker926.leetcode.algorithms.p0850.s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2022/9/16
 * @description 扫描线
 * 还有更复杂的方法
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int rectangleArea(int[][] rectangles) {
        List<Integer> xs = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            xs.add(rectangle[0]);
            xs.add(rectangle[2]);
        }
        Collections.sort(xs);
        long ans = 0;
        for (int i = 1; i < xs.size(); i++) {
            int left = xs.get(i - 1), right = xs.get(i), len = right - left;
            if (len == 0) {
                continue;
            }
            List<int[]> ys = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                if (rectangle[0] <= left && rectangle[2] >= right) {
                    ys.add(new int[]{rectangle[1], rectangle[3]});
                }
            }
            ys.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            long total = 0, bottom = -1, top = -1;
            for (int[] y : ys) {
                if (y[0] > top) {
                    total += top - bottom;
                    bottom = y[0];
                    top = y[1];
                } else if (y[1] > top) {
                    top = y[1];
                }
            }
            total += top - bottom;
            ans = (ans + len * total) % MOD;
        }
        return (int) ans;
    }
}
