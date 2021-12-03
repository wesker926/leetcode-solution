package com.wesker926.leetcode.algorithms.p1005.s1;

/**
 * @author wesker.gh
 * @date 2021/12/3
 * @description 贪心 + 桶排序
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] bucket = new int[201];
        for (int num : nums) {
            bucket[num + 100]++;
        }

        int sum = 0, min = 100, num, count;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                continue;
            }

            count = bucket[i];
            num = i - 100;
            if (num >= 0) {
                sum += num * count;
            } else {
                if (k >= count) {
                    sum += (-num) * count;
                    k -= count;
                } else {
                    sum += (-num) * k;
                    sum += num * (count - k);
                    k = 0;
                }
                num = -num;
            }
            min = Math.min(min, num);
        }

        return (k & 1) == 0 ? sum : sum - min * 2;
    }
}
