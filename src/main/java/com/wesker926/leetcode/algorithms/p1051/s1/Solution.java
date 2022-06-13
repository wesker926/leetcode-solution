package com.wesker926.leetcode.algorithms.p1051.s1;

/**
 * @author wesker.gh
 * @date 2022/6/13
 * @description 桶排（计数排序）
 * 适用于数据范围比较小的情况
 * 通用解法是复制数组排序后比较
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int height : heights) {
            bucket[height]++;
        }
        int ans = 0, idx = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                if (heights[idx++] != i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
