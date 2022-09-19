package com.wesker926.leetcode.algorithms.p1636.s1;

import java.util.Arrays;

/**
 * @author wesker.gh
 * @date 2022/9/19
 * @description 模拟
 * 哈希表 + 排序
 */
public class Solution {
    public int[] frequencySort(int[] nums) {
        int[] counts = new int[201];
        Integer[] sort = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] + 100]++;
            sort[i] = nums[i];
        }
        Arrays.sort(sort, (a, b) -> counts[a + 100] != counts[b + 100] ? counts[a + 100] - counts[b + 100] : b - a);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sort[i];
        }
        return nums;
//        return Arrays.stream(nums).boxed()
//                .sorted((a, b) -> counts[a + 100] != counts[b + 100] ? counts[a + 100] - counts[b + 100] : b - a)
//                .mapToInt(Integer::intValue).toArray();
    }
}
