package com.wesker926.leetcode.algorithms.p0823.s1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wesker.gh
 * @date 2023/8/29
 * @description 双指针 + DP
 * 子节点可以用left和right，优化掉map
 * https://leetcode.cn/problems/binary-trees-with-factors/solutions/2414616/dai-yin-zi-de-er-cha-shu-by-leetcode-sol-0082/
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> count = new HashMap<>();
        long ans = 0, cur;
        for (int i = 0, j; i < arr.length; i++) {
            for (cur = 1, j = 0; arr[i] / arr[j] >= arr[j]; j++) {
                int factor = arr[i] / arr[j];
                if (factor * arr[j] != arr[i]) continue;
                cur = (count.getOrDefault(arr[j], 0L) *
                        count.getOrDefault(factor, 0L) * (factor == arr[j] ? 1 : 2) + cur) % MOD;
            }
            count.put(arr[i], cur);
            ans = (ans + cur) % MOD;
        }
        return (int) ans;
    }
}
