package com.wesker926.leetcode.algorithms.p0128.s2;

import java.util.HashSet;

/**
 * @author wesker.gh
 * @date 2022/5/20
 * @description 哈希表
 * 从连续区间第一个数进入内层遍历，所以所有数只会遍历一次。
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int cur = i + 1;
            for (; set.contains(cur); cur++) {
            }
            ans = Math.max(ans, cur - i);
        }
        return ans;
    }
}
