package com.wesker926.leetcode.algorithms.p2171.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2024/1/18
 * @description 排序 + 遍历
 * 一开始可能以为是前后缀和，其实只需要sum即可。
 * 可用计数排序替代排序，核心逻辑不变。
 */
public class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long ans = Long.MAX_VALUE, sum = 0;
        for (int bean : beans) sum += bean;
        for (int i = 0, n = beans.length; i < n; i++) {
            ans = Math.min(ans, sum - (n - i) * (long) beans[i]);
        }
        return ans;
    }
}
