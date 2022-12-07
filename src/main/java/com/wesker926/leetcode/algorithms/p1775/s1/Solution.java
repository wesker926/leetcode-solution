package com.wesker926.leetcode.algorithms.p1775.s1;

/**
 * @author wesker.gh
 * @date 2022/12/7
 * @description 贪心 + 哈希表
 */
public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }
        int[] bucket1 = getBucket(nums1), bucket2 = getBucket(nums2);
        int diff = bucket2[0] - bucket1[0];
        return diff == 0 ? 0 : (diff > 0 ? getOperations(bucket1, bucket2, diff) : getOperations(bucket2, bucket1, -diff));
    }

    private int getOperations(int[] bucket1, int[] bucket2, int diff) {
        int[] table = getTable(bucket1, bucket2);
        int ans = 0;
        for (int num = 5; num > 0 && diff > 0; num--) {
            int count = Math.min((diff - 1) / num + 1, table[num]);
            ans += count;
            diff -= count * num;
        }
        return ans;
    }

    private int[] getBucket(int[] nums) {
        int[] bucket = new int[8];
        for (int num : nums) {
            bucket[num]++;
            bucket[0] += num;
        }
        return bucket;
    }

    private int[] getTable(int[] bucket1, int[] bucket2) {
        int[] table = new int[6];
        for (int i = 1; i < 7; i++) {
            table[6 - i] += bucket1[i];
            table[i - 1] += bucket2[i];
        }
        return table;
    }
}
