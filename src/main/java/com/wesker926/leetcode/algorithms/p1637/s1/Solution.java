package com.wesker926.leetcode.algorithms.p1637.s1;

/**
 * @author wesker.gh
 * @date 2023/3/30
 * @description 分桶
 * 分桶可以实现O(n)复杂度，这题用桶是不需要完全排序的，仅需分桶。
 * n+1个桶，当max != min时，至少存在两个桶有数据。
 * 桶内记录当前范围的max和min。
 * ans为max(ans, cur_min - pre_max)。
 */
public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length, max = points[0][0], min = max;
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
        }
        if (max == min) {
            return 0;
        }

        int[][] bucket = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            bucket[i] = new int[]{-1, max};
        }

        for (int[] point : points) {
            int idx = (int) (((long) point[0] - min) * n / (max - min));
            bucket[idx][0] = Math.max(bucket[idx][0], point[0]);
            bucket[idx][1] = Math.min(bucket[idx][1], point[0]);
        }

        int pre = bucket[0][0], ans = 0;
        for (int i = 1; i <= n; i++) {
            if (bucket[i][0] != -1) {
                ans = Math.max(ans, bucket[i][1] - pre);
                pre = bucket[i][0];
            }
        }
        return ans;
    }
}
