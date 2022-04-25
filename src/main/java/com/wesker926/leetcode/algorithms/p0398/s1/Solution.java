package com.wesker926.leetcode.algorithms.p0398.s1;

import java.util.*;

/**
 * @author wesker.gh
 * @date 2022/4/25
 * @description 哈希表
 */
public class Solution {

    private final Map<Integer, List<Integer>> map = new HashMap<>();

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get((int) (list.size() * Math.random()));
    }
}
