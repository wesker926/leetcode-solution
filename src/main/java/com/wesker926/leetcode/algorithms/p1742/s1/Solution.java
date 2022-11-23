package com.wesker926.leetcode.algorithms.p1742.s1;

/**
 * @author wesker.gh
 * @date 2022/11/23
 * @description 哈希表 + 遍历模拟
 */
public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] bucket = new int[46];
        for (int i = lowLimit, j; i <= highLimit; i = j) {
            j = (i / 10 + 1) * 10;
            for (int k = i, sum = sum(i); k < j && k <= highLimit; k++, sum++) {
                bucket[sum]++;
                ans = Math.max(ans, bucket[sum]);
            }
        }
        return ans;
    }

    private int sum(int i) {
        int sum = 0;
        for (; i != 0; i /= 10) {
            sum += i % 10;
        }
        return sum;
    }
}
