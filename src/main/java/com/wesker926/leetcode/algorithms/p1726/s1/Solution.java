package com.wesker926.leetcode.algorithms.p1726.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/10/19
 * @description 哈希
 * 可以先统计后计算，也可以边统计边计算
 */
public class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                int cur = countMap.getOrDefault(key, 0);
                countMap.put(key, cur + 1);
                ans += 2 * cur;
            }
        }
        return ans << 2;
    }
}
