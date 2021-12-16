package com.wesker926.leetcode.algorithms.p1610.s1;

import java.util.Arrays;
import java.util.List;

/**
 * @author wesker.gh
 * @date 2021/12/16
 * @description 坐标转换 + 滑动窗口
 */
public class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int same = 0, x1 = location.get(0), x2, y1 = location.get(1), y2, idx = 0, n = points.size();
        double[] polars = new double[n * 2];
        for (List<Integer> point : points) {
            x2 = point.get(0);
            y2 = point.get(1);
            if (x1 == x2 && y1 == y2) {
                same++;
            } else {
                polars[idx++] = Math.atan2(y2 - y1, x2 - x1);
            }
        }

        n = idx;
        Arrays.sort(polars, 0, n);
        for (idx = 0; idx < n; idx++) {
            polars[idx + n] = polars[idx] + Math.PI * 2;
        }

        int max = 0;
        double scope = angle * Math.PI / 180;
        for (int i = 0, j = 0; i < n; i++) {
            for (; j < polars.length && polars[j] <= scope + polars[i]; j++) {
            }
            max = Math.max(max, j - i);
        }
        return max + same;
    }
}
