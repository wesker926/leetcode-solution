package com.wesker926.leetcode.algorithms.p0164.s2;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/6/2
 * @description 落桶算极值
 * 最大差值必然不小于(max - min) / (n - 1)
 */
public class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = nums[0], min = max;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;
        int[][] bucket = new int[bucketCount][2];
        for (int i = 0; i < bucketCount; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = bucket[idx][1] = num;
            } else {
                bucket[idx][0] = Math.max(bucket[idx][0], num);
                bucket[idx][1] = Math.min(bucket[idx][1], num);
            }
        }
        int res = 0, pre = -1;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] == -1) {
                continue;
            }
            if (pre != -1) {
                res = Math.max(res, bucket[i][1] - bucket[pre][0]);
            }
            pre = i;
        }
        return res;
    }
}
