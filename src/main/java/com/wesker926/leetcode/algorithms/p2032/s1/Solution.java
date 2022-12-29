package com.wesker926.leetcode.algorithms.p2032.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/12/29
 * @description 哈希 + 二进制
 */
public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] bucket = new int[101];
        build(bucket, nums1, nums2, nums3);
        for (int i = 0; i < bucket.length; i++) {
            if ((bucket[i] & (bucket[i] - 1)) != 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void build(int[] bucket, int[]... arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int num : arrays[i]) {
                bucket[num] |= (1 << i);
            }
        }
    }
}
