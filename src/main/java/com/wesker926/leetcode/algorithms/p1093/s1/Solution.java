package com.wesker926.leetcode.algorithms.p1093.s1;

/**
 * @author wesker.gh
 * @date 2023/5/27
 * @description 遍历
 */
public class Solution {
    public double[] sampleStats(int[] count) {
        int total = 0, maxCount = 0;
        double[] ans = new double[]{Double.MAX_VALUE, Double.MIN_VALUE, 0, 0, 0};
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            ans[0] = Math.min(ans[0], i);
            ans[1] = Math.max(ans[1], i);
            int newTotal = total + count[i];
            ans[2] = ((double) total) / newTotal * ans[2] + ((double) count[i]) / newTotal * i;
            total = newTotal;
            if (count[i] > maxCount) {
                maxCount = count[i];
                ans[4] = i;
            }
        }
        int a = (total + 1) >> 1, b = (total + 2) >> 1;
        for (int i = 0, c = 0; i < count.length && (a > 0 || b > 0); i++) {
            if (count[i] == 0) continue;
            if ((c += count[i]) >= a && a > 0) a = -i;
            if (b > 0 && c >= b) b = -i;
        }
        ans[3] = (-a - b) / 2.0;
        return ans;
    }
}
